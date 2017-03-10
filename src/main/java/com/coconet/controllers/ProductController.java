package com.coconet.controllers;

import com.coconet.model.*;
import com.coconet.service.SubscriberManager;
import com.coconet.service.SubscriptionPlanManager;
import com.coconet.util.SubscriptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Prithu on 02-03-2017.
 */
@Controller
public class ProductController{
    @Autowired
    private SubscriptionPlanManager subscriptionPlanManager;
    @Autowired
    private SubscriberManager subscriberManager;
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
            subscription=SubscriptionUtil.startAndEndDateSetter(subscription, subscriptionPlan);
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
    @RequestMapping(value = "/product/subscribe")
    public String subscribeProduct(@ModelAttribute("subscription")Subscription subscription, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            _log.info("hasErrors :"+bindingResult.hasErrors());
            return "product-details";
        }
        _log.info(subscription);
        return "subscriptionSuccess";
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
