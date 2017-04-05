package com.coconet.controllers;

import com.coconet.model.*;
import com.coconet.service.*;
import com.coconet.util.Mailer;
import com.coconet.util.SubscriptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Prithu on 02-03-2017.
 */
@Controller
public class ProductController{
    @Autowired
    private SubscriptionPlanManager subscriptionPlanManager;
    @Autowired
    private MailService mailService;
    @Autowired
    private SubscriberManager subscriberManager;
    @Autowired
    private SubscriptionManager subscriptionManager;
    @Autowired
    private AddressManager addressManager;
    @Autowired
    OnlinePaymentProcessor onlinePaymentProcessor;
    @Value("${mail.standard.bcc.list}")
    private String[] bccList;
    private static final Log _log = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product/{productId}/subscriptionPlan/{subscriptionPlanId}")
    public String showProductDetails(@PathVariable("productId") int productId,
                                     @PathVariable("subscriptionPlanId") int subscriptionPlanId,
                                     Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber)auth.getPrincipal();
            Subscriber subscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
            SubscriptionPlan subscriptionPlan=subscriptionPlanManager.getSubscriptionPlan(subscriptionPlanId);
            Subscription subscription =new Subscription();
            Calendar startDateCal = Calendar.getInstance();
            startDateCal.setTime(new Date());
            startDateCal.add(Calendar.DATE,1);
            subscription=SubscriptionUtil.startAndEndDateSetter(subscription, subscriptionPlan, startDateCal.getTime());
            model.addAttribute("subscriptionPlan", subscriptionPlan);
            model.addAttribute("subscription",subscription);
            model.addAttribute("subscriber",subscriber);
            _log.info(subscriber.getAddresses());
            return "product-details";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
    }
    @RequestMapping(value = "/product/subscribe", method = RequestMethod.POST)
    public String subscribeProduct(@ModelAttribute("subscription")Subscription subscription, BindingResult bindingResult,Model model){
        String paymentUrl=null;
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber)auth.getPrincipal();
            Subscriber subscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
            SubscriptionPlan subscriptionPlan=subscriptionPlanManager.getSubscriptionPlan(subscription.getSubscriptionPlan().getId());
            model.addAttribute("subscriptionPlan", subscriptionPlan);
            model.addAttribute("subscription",subscription);
            model.addAttribute("subscriber",subscriber);
            if (bindingResult.hasErrors()) {
                _log.info("hasErrors :" + bindingResult.hasErrors() + bindingResult.toString());
                return "product-details";
            }
            BigDecimal pricePerUnit=subscriptionPlan.getProduct().getPricePerUnit();
            BigDecimal totalQuantity = subscription.getTotalQuantity();
            BigDecimal price = SubscriptionUtil.priceCalculator(totalQuantity, pricePerUnit);
            subscription.setActualPrice(price);
            subscription.setTotalPrice(price);
            subscription.setPaymentStatus("pending");
            subscription.setSubscriptionStatus("initialized");
            subscription.setSubscriber(subscriber);
            subscription.setSubscriptionPlan(subscriptionPlan);
            subscription.setDeliveryAddress(addressManager.getAddress(subscription.getDeliveryAddress().getId()));
            subscription.setCreateDate(new Date());
            subscriptionManager.saveOrUpdate(subscription); /*Saving subscription*/
            if (subscription.getPaymentType().equals("cod")) {
                subscription=SubscriptionUtil.setSubscriptionDeliveryRecords(subscription);
                subscription=SubscriptionUtil.setPaymentDetails(subscription,null,null);
                subscriptionManager.saveOrUpdate(subscription); /*Saving subscription*/
                _log.info("Sending Email about subscription to " + subscriber.getEmail());
                _log.info(subscription);
                String[] recipients = {subscriber.getEmail()};
                Mailer mailer = new Mailer();
                mailer.setRecipients(recipients);
                mailer.setBccList(bccList);
                mailer.setSubject(subscriptionPlan.getProduct().getProductName() + " Subscription Initialized");
                HashMap<String, String> mailTemplateData = new HashMap<String, String>();
                mailTemplateData.put("userName", subscriber.getFirstName() + " " + subscriber.getLastName());
                mailTemplateData.put("productSubscriptionPlanName", subscriptionPlan.getProduct().getProductName() + " " +
                        subscriptionPlan.getPlanName());
                mailTemplateData.put("startDate", (subscription.getStartDate().toString()).substring(0, 10));
                mailTemplateData.put("endDate", (subscription.getEndDate().toString()).substring(0, 10));
                mailTemplateData.put("paymentType", subscription.getPaymentType());
                mailTemplateData.put("totalPrice", subscription.getTotalPrice() + "");
                mailTemplateData.put("deliveryAddress", subscription.getDeliveryAddress().toString());
                mailTemplateData.put("preferredDeliveryTime", subscription.getPreferredDeliveryTime().toString());
                mailTemplateData.put("numberOfCoconuts", (subscription.getTotalQuantity()) + "");
                mailTemplateData.put("templateName", "mailTemplates/subscriptionDetails");
                mailService.prepareAndSend(mailer, mailTemplateData);
                return "redirect:/subscriber/subscriptions?subscribed=true";
            }else {
                paymentUrl = onlinePaymentProcessor.placeOrder(subscription);
                return paymentUrl!=null?"redirect:"+paymentUrl:"exceptionError";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
    }
    @RequestMapping(value = "/product/subscriberAddAddress")
    private String subscriberAddAddress(@ModelAttribute("address")Address address, Model model, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoggedInSubscriber loggedInSubscriber=(LoggedInSubscriber)auth.getPrincipal();
        Subscriber subscriber =subscriberManager.findByEmail(loggedInSubscriber.getEmail());
        if (address.getAddressHolderName()==null){
            address.setAddressHolderName(subscriber.getFirstName());
        }
        address.setSubscriber(subscriber);
        subscriber.getAddresses().add(address);
        String referer = request.getHeader("Referer");
        _log.info("Referer : "+referer);
        subscriberManager.saveOrUpdate(subscriber);
        _log.info("Subscriber address:"+address);
        return "redirect:"+ referer;
    }
}
