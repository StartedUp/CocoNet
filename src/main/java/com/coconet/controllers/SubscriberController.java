package com.coconet.controllers;

import com.coconet.model.LoggedInSubscriber;
import com.coconet.model.Subscriber;
import com.coconet.service.MailService;
import com.coconet.service.SubscriberManager;
import com.coconet.util.Mailer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Prithu on 13-03-2017.
 */
@Controller
public class SubscriberController {
    @Autowired
    SubscriberManager subscriberManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;
    private static final Log _log = LogFactory.getLog(SubscriberController.class);

    @RequestMapping(value = "/subscriber/profile")
    public String subscriberProfile(Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()) {
                LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber) auth.getPrincipal();
                Subscriber subscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
                model.addAttribute("subscriber", subscriber);
                return "subscriberProfile";
            }else
                return "loginPage";
        }catch (Exception e){
            e.printStackTrace();
            return "exceptionError";
        }
    }
    @RequestMapping(value = "/subscriber/profileUpdate", method = RequestMethod.POST)
    public String subscriberProfileUpdate(@ModelAttribute("subscriber")Subscriber subscriber, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            _log.info("hasErrors :"+bindingResult.hasErrors());
            return "subscriberProfile";
        }
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()) {
                String newEmail=subscriber.getEmail();
                String token="";
                LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber) auth.getPrincipal();
                Subscriber currentSubscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
                if (subscriber.getPassword()!=null && !subscriber.getPassword().equals("")) {
                    subscriber.setPassword(passwordEncoder.encode(subscriber.getPassword()));
                    SecurityContextHolder.getContext().setAuthentication(null);
                }else
                    subscriber.setPassword(currentSubscriber.getPassword());
                if (!subscriber.getEmail().trim().equals(loggedInSubscriber.getEmail())) {
                    token = UUID.randomUUID().toString();
                    subscriber.setActive(currentSubscriber.isActive());
                    subscriber.setRegistrationToken(token);
                    subscriber.setEmail(loggedInSubscriber.getEmail());
                }else {
                    subscriber.setRegistrationToken(currentSubscriber.getRegistrationToken());
                    subscriber.setActive(currentSubscriber.isActive());
                }
                subscriber.setId(currentSubscriber.getId());
                subscriber.setCreateDate(currentSubscriber.getCreateDate());
                subscriberManager.saveOrUpdate(subscriber);
                if (!newEmail.equals(loggedInSubscriber.getEmail())) {
                    _log.info("Sending Email to request email update to " + newEmail);
                    String[] recipients = {newEmail};
                    String[] bccList = {"dydhanraj5@gmail.com", "rprithviprakash@gmail.com", "admin@madeintrees.com"};
                    String confirmEmailUrl = "/updateEmail/" + newEmail + "/" + token;
                    Mailer mailer = new Mailer();
                    mailer.setRecipients(recipients);
                    mailer.setBccList(bccList);
                    mailer.setSubject("MadeInTrees Email update");
                    HashMap<String, String> mailTemplateData = new HashMap<String, String>();
                    mailTemplateData.put("userName", subscriber.getFirstName() + " " + subscriber.getLastName());
                    mailTemplateData.put("confirmEmailUrl", confirmEmailUrl);
                    mailTemplateData.put("templateName", "mailTemplates/updateEmail");
                    mailService.prepareAndSend(mailer, mailTemplateData);
                    return "redirect:/subscriber/profile?emailUpdate=true";
                }
                return SecurityContextHolder.getContext().getAuthentication()!=null?"redirect:/subscriber/profile?profileUpdate=true":"redirect:/loginPage?passwordUpdate=true";
            }else
                return "/loginPage";
        }catch (Exception e) {
            e.printStackTrace();
            return "exceptionError";
        }
    }
    @RequestMapping(value = "/updateEmail/{email}/{token}")
    public String updateEmail(@PathVariable("email") String email, @PathVariable("token") String token, Model model){
        try {
            Subscriber subscriber =subscriberManager.findByToken(token);
            subscriber.setEmail(email);
            subscriberManager.saveOrUpdate(subscriber);
            model.addAttribute(subscriber);
            SecurityContextHolder.getContext().setAuthentication(null);
            return "redirect:/loginPage?emailUpdate=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "exceptionError";
        }
    }
}
