package com.coconet.mit.customerPortal.controllers;

import com.coconet.mit.commons.model.*;
import com.coconet.mit.customerPortal.service.MailService;
import com.coconet.mit.customerPortal.service.SubscriberManager;
import com.coconet.mit.customerPortal.service.SubscriptionManager;
import com.coconet.mit.customerPortal.util.Mailer;
import com.coconet.mit.customerPortal.util.SubscriptionUtil;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by Prithu on 13-03-2017.
 */
@Controller
public class SubscriptionController {
    @Autowired
    SubscriberManager subscriberManager;
    @Autowired
    private SubscriptionManager subscriptionManager;
    @Autowired
    private MailService mailService;
    @Value("${mail.standard.bcc.list}")
    private String[] bccList;
    @Value("${payment.online.instamojo.api.endpoint}")
    private String instamojoApiEndpoint;
    @Value("${payment.online.instamojo.auth.endpoint}")
    private String instamojoAuthEndpoint;
    @Value("${payment.online.instamojo.client.id}")
    private String instamojoClientId;
    @Value("${payment.online.instamojo.client.secret}")
    private String instamojoClientSecret;

    private static final Log _log = LogFactory.getLog(SubscriptionController.class);

    @RequestMapping(value = "/subscriber/subscriptions")
    public String listSubscriptions(Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()) {
                LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber) auth.getPrincipal();
                Subscriber subscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
                model.addAttribute("subscriptions", subscriber.getSubscriptions());
                _log.info(subscriber.getSubscriptions());
                return "subscriptions";
            }else
                return "loginPage";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
    }
    @RequestMapping(value = "/subscriber/subscription/paymentStatus")
    public String onlinePaymentStatus(@RequestParam("id") String paymentRequestId, @RequestParam("transaction_id") int transactionId, @RequestParam("payment_id") String paymentId){
        Subscription subscription=subscriptionManager.getSubscriptionById(transactionId);
        SubscriptionPlan subscriptionPlan=subscription.getSubscriptionPlan();
        Product product=subscriptionPlan.getProduct();
        try {
            Instamojo api = InstamojoImpl.getApi(instamojoClientId, instamojoClientSecret, instamojoApiEndpoint, instamojoAuthEndpoint);

            PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetailsByTransactionId(transactionId+"");
            // print the status of the payment order.
            _log.info("paymentOrderDetailsResponse.getStatus() "+paymentOrderDetailsResponse.getStatus());
            String status =paymentOrderDetailsResponse.getStatus();
            if (status.equals("completed")){
                subscription=subscriptionManager.getSubscriptionById(transactionId);
                if (subscription.getSubscriptionStatus()!=null &&!subscription.getSubscriptionStatus().equals("expired")) {
                    subscription.setPaymentStatus(status);
                    subscription.setSubscriptionStatus("active");
                    subscription=SubscriptionUtil.setSubscriptionDeliveryRecords(subscription);
                    subscription=SubscriptionUtil.setPaymentDetails(subscription, paymentOrderDetailsResponse, paymentId);
                    subscriptionManager.saveOrUpdate(subscription);
                }
                return sendSuccessMail(subscription);
            }else {
                return "/subscriber/" +product.getId()+"/"+subscriptionPlan.getId()+"?onlinePaymentFailed=true&subscriptionId=" + transactionId;
            }
        } catch (Exception e) {
            //LOGGER.log(Level.SEVERE, e.toString(), e);
            e.printStackTrace();
            return "/subscriber/" +product.getId()+"/"+subscriptionPlan.getId()+"?onlinePaymentFailed=true&subscriptionId=" + transactionId;
        }
    }

    public String sendSuccessMail(Subscription subscription){
        Subscriber subscriber=subscription.getSubscriber();
        SubscriptionPlan subscriptionPlan = subscription.getSubscriptionPlan();
        _log.info("Sending Email about subscription to " + subscriber.getEmail());
        _log.info(subscription);
        String[] recipients = {subscriber.getEmail()};
        Mailer mailer = new Mailer();
        mailer.setRecipients(recipients);
        mailer.setBccList(bccList);
        mailer.setSubject(subscriptionPlan.getProduct().getProductName() + " Subscription Initialized and Activated");
        HashMap<String, String> mailTemplateData = new HashMap<String, String>();
        mailTemplateData.put("userName", subscriber.getFirstName() + " " + subscriber.getLastName());
        mailTemplateData.put("productSubscriptionPlanName", subscriptionPlan.getProduct().getProductName() + " " +
                subscriptionPlan.getPlanName());
        mailTemplateData.put("startDate", (subscription.getStartDate().toString()).substring(0, 10));
        mailTemplateData.put("endDate", (subscription.getEndDate().toString()).substring(0, 10));
        mailTemplateData.put("paymentType", subscription.getPaymentType());
        mailTemplateData.put("totalPrice", subscription.getTotalPrice() + "");
        mailTemplateData.put("preferredDeliveryTime", subscription.getPreferredDeliveryTime().toString());
        mailTemplateData.put("deliveryAddress", subscription.getDeliveryAddress().toString());
        mailTemplateData.put("numberOfCoconuts", (subscription.getTotalQuantity()) + "");
        mailTemplateData.put("templateName", "mailTemplates/subscriptionDetails");
        mailService.prepareAndSend(mailer, mailTemplateData);
        return "redirect:/subscriber/subscriptions?subscribed=true&payment=true";
    }

    @RequestMapping(value = "/subscriber/subscription/{id}")
    public String showSubscription(@PathVariable("id") int id, Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()) {
               Subscription subscription= subscriptionManager.getSubscriptionByIdEager(id);
                model.addAttribute("subscription",subscription);
                return "showSubscription";
            }else
                return "redirect:/loginPage";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
    }
}
