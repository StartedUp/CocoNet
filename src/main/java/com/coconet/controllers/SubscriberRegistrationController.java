package com.coconet.controllers;

import com.coconet.model.Subscriber;
import com.coconet.service.SubscriberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Prithu on 27-12-2016.
 */
@Controller
public class SubscriberRegistrationController {
    @Autowired
    private SubscriberManager subscriberManager;

    private static final Log _log = LogFactory.getLog(SubscriberRegistrationController.class);

    @RequestMapping(value= "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("subscriber")Subscriber subscriber, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            _log.info("hasErrors :"+bindingResult.hasErrors());
            return "signup";
        }
        _log.info("subscriber in form :"+ subscriber);
        try {
            Subscriber checkSubscriber= subscriberManager.findByEmail(subscriber.getEmail());
            _log.info("Subscriber found by email : "+checkSubscriber);
            if (checkSubscriber==null)
                subscriberManager.saveOrUpdate(subscriber);
            else
                return "duplicateRegistration";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
        return "signupSuccess";
    }
}
