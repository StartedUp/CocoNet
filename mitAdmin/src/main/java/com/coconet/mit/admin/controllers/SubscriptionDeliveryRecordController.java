package com.coconet.mit.admin.controllers;

import com.coconet.mit.commons.model.Subscription;
import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;
import com.coconet.mit.admin.service.SubscriptionDeliveryRecordManager;
import com.coconet.mit.admin.service.SubscriptionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Prithu on 31-03-2017.
 */
@Controller
public class SubscriptionDeliveryRecordController {
    @Autowired
    private SubscriptionManager subscriptionManager;
    @Autowired
    private SubscriptionDeliveryRecordManager subscriptionDeliveryRecordManager;
    private static final Log _log = LogFactory.getLog(SubscriptionDeliveryRecordController.class);
    @RequestMapping(value = "/subscriptionDeliveryUpdate", method = RequestMethod.POST)
    public String subscriptionDeliveryUpdate(@ModelAttribute("subscriptionDeliveryRecord")SubscriptionDeliveryRecord subscriptionDeliveryRecord,
                                             BindingResult bindingResult, Model model){
        _log.info("hi there "+subscriptionDeliveryRecord);
        Subscription subscription =subscriptionManager.findById(subscriptionDeliveryRecord.getSubscription().getId());
        BigDecimal quantityPerDay = subscription.getQuantityPerDay();
        BigDecimal quantityDelivered =subscriptionDeliveryRecord.getQuantityDelivered();
        Boolean delivered =subscriptionDeliveryRecord.isDelivered();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()) {
                if (quantityDelivered.compareTo(quantityPerDay) == -1 && !delivered) {
                    return "redirect:/user?deliveryUpdate=false";
                } else {
                    subscriptionDeliveryRecord.setSubscription(subscription);
                    subscriptionDeliveryRecord.setUpdatedAt(new Date());
                    subscriptionDeliveryRecordManager.save(subscriptionDeliveryRecord);
                    return "redirect:/user?deliveryUpdate=true";
                }
            }
            else
                return "redirect:/user";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/user?deliveryUpdate=exception";
        }
    }
}
