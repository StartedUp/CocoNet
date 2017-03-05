package com.coconet.controllers;

import com.coconet.model.Subscription;
import com.coconet.service.SubscriptionPlanManager;
import com.coconet.util.SubscriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prithu on 02-03-2017.
 */
@Controller
public class ProductController{
    @Autowired
    private SubscriptionPlanManager subscriptionPlanManager;

    @RequestMapping(value = "/product/{productId}/subscriptionPlan/{subscriptionPlanId}")
    public String showProductDetails(@PathVariable("productId") int productId,
                                     @PathVariable("subscriptionPlanId") int subscriptionPlanId,
                                     Model model){
        Subscription subscription =new Subscription();
        subscription=SubscriptionUtil.startAndEndDateSetter(subscription);
        model.addAttribute("subscriptionPlan", subscriptionPlanManager.getSubscriptionPlan(subscriptionPlanId));
        model.addAttribute("subscription",subscription);
        return "Product-details";
    }
}
