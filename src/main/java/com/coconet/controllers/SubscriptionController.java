package com.coconet.controllers;

import com.coconet.model.LoggedInSubscriber;
import com.coconet.model.Subscriber;
import com.coconet.service.SubscriberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prithu on 13-03-2017.
 */
@Controller
public class SubscriptionController {
    @Autowired
    SubscriberManager subscriberManager;
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
}
