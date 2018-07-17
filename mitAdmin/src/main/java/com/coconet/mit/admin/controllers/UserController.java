package com.coconet.mit.admin.controllers;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;
import com.coconet.mit.admin.service.SubscriptionDeliveryRecordManager;
import com.coconet.mit.admin.service.SubscriptionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Prithu on 29-03-2017.
 */
@Controller
public class UserController {
    @Autowired
    private SubscriptionDeliveryRecordManager subscriptionDeliveryRecordManager;
    @Autowired
    private SubscriptionManager subscriptionManager;
    private static final Log _log = LogFactory.getLog(UserController.class);
    @RequestMapping(value = "/user")
    public String showUserPage(Model model){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        List<SubscriptionDeliveryRecord> subscriptionDeliveryRecords=subscriptionDeliveryRecordManager
                .findByDate(cal.getTime());
        model.addAttribute("subscriptionDeliveryRecordsToday", subscriptionDeliveryRecords);
        _log.info("subscriptionDeliveryRecordsToday : "+ subscriptionDeliveryRecords);
        return "userHome";
    }
}
