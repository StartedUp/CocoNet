package com.coconet.mit.customerPortal.controllers;

import com.coconet.mit.customerPortal.model.SubscriptionPlan;
import com.coconet.mit.customerPortal.service.SubscriptionPlanManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Admin on 17-12-2016.
 */
@Controller
public class WebAppHomeController {
    @Autowired
    private SubscriptionPlanManager subscriptionPlanManager;
    private static final Log _log = LogFactory.getLog(WebAppHomeController.class);

    @RequestMapping("/")
    public String webAppHome(Model model){
        List<SubscriptionPlan> subscriptionPlans=subscriptionPlanManager.subscriptionPlans();
        _log.info(subscriptionPlans);
        model.addAttribute("subscriptionPlans", subscriptionPlans);
        return "webAppHome";
    }
    @RequestMapping("/welcome")
    public String welcomeHome(Model model){
        List<SubscriptionPlan> subscriptionPlans=subscriptionPlanManager.subscriptionPlans();
        _log.info(subscriptionPlans);
        model.addAttribute("subscriptionPlans", subscriptionPlans);
        return "webAppHome";
    }
    @RequestMapping("/loginPage")
    public  String loginPage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
    /* The user is logged in :) */
            return "redirect:/welcome?loggedin=true";
        }
        return "loginPage";
    }
    @RequestMapping("/signupPage")
    public String signupPage() {
        return "signupPage";
    }
}
