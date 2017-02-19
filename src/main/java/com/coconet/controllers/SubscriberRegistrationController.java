package com.coconet.controllers;

import com.coconet.model.Subscriber;
import com.coconet.service.MailService;
import com.coconet.service.SubscriberManager;
import com.coconet.util.Mailer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Prithu on 27-12-2016.
 */
@Controller
public class SubscriberRegistrationController {
    @Autowired
    private MailService mailService;
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
            if (checkSubscriber==null) {
                String token = UUID.randomUUID().toString();
                subscriber.setRegistrationToken(token);
                subscriberManager.saveOrUpdate(subscriber);
                _log.info("Sending Email confirmation mail to " + subscriber.getEmail());
                String [] recipients ={subscriber.getEmail()};
                String confirmEmailUrl="/confirmEmail/"+subscriber.getEmail()+"/"+token;
                Mailer mailer=new Mailer();
                mailer.setRecipients(recipients);
                mailer.setSubject("Coconet Email confirmation");
                HashMap<String, String> mailTemplateData = new HashMap<String, String>();
                mailTemplateData.put("userName",subscriber.getFirstName()+" "+subscriber.getLastName());
                mailTemplateData.put("confirmEmailUrl",confirmEmailUrl);
                mailTemplateData.put("templateName","mailTemplateConfirmEmail");
                mailService.prepareAndSend(mailer, mailTemplateData);
            }
            else
                return "duplicateRegistration";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
        return "signupSuccess";
    }
    @RequestMapping(value = "/confirmEmail/{email}/{token}",method = RequestMethod.GET)
    public String confirmEmail(@PathVariable("email") String email, @PathVariable("token") String token, Model model){
        Subscriber subscriberByEmailAndToken=subscriberManager.findByEmailAndToken(email, token);
        if (subscriberByEmailAndToken!=null) {
            subscriberByEmailAndToken.setActive(true);
            _log.info("subscriberByEmailAndToken :"+subscriberByEmailAndToken+" isActive :"+subscriberByEmailAndToken.isActive());
            subscriberManager.update(subscriberByEmailAndToken);
            model.addAttribute("subscriberByEmailAndToken", subscriberByEmailAndToken);
            return "loginPage";
        }else
            return "exceptionError";
    }
}
