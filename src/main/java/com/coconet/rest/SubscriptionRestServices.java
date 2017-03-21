package com.coconet.rest;

import com.coconet.model.*;
import com.coconet.service.MailService;
import com.coconet.service.SubscriptionDeliveryRecordManager;
import com.coconet.service.SubscriptionManager;
import com.coconet.util.Mailer;
import com.coconet.util.SubscriptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Prithu on 18-03-2017.
 */
@RestController
public class SubscriptionRestServices {
    @Autowired
    private SubscriptionManager subscriptionManager;
    @Autowired
    private SubscriptionDeliveryRecordManager subscriptionDeliveryRecordManager;
    @Autowired
    private MailService mailService;
    private static final Log _log = LogFactory.getLog(SubscriptionRestServices.class);
    @RequestMapping(value = "/subscription/getTotalPrice", method = RequestMethod.GET)
    public ResponseEntity<String> calculateTotalPrice(@RequestParam("pricePerUnit") BigDecimal pricePerUnit, @RequestParam("totalQuantity") BigDecimal totalQuantity) {
        BigDecimal totalPrice = SubscriptionUtil.priceCalculator(totalQuantity, pricePerUnit);
        return ResponseEntity.ok(totalPrice + "");
    }

    @RequestMapping(value = "/subscription/undelivered", method = RequestMethod.GET)
    public ResponseEntity<String> reportUndelivered(@RequestParam("subscriptionId") Integer subscriptionId, @RequestParam("subscriptionDeliveryRecordId") Integer subscriptionDeliveryRecordId) {
        _log.info("@@RequestParam : subscriptionId=" + subscriptionId+", subscriptionDeliveryRecordId="+subscriptionDeliveryRecordId);
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.isAuthenticated()&&subscriptionId !=null && subscriptionDeliveryRecordId != null) {
                Subscription subscription=subscriptionManager.getSubscriptionById(subscriptionId);
                SubscriptionDeliveryRecord subscriptionDeliveryRecord =subscriptionDeliveryRecordManager
                        .getSubscriptionDeliveryRecordById(subscriptionDeliveryRecordId);
                if (subscription.getId()==subscriptionDeliveryRecord.getSubscription().getId()){
                    subscriptionDeliveryRecord.setDelivered(false);
                    subscriptionDeliveryRecord.setQuantityDelivered(new BigDecimal(0));
                    subscriptionDeliveryRecord.setUpdatedAt(new Date());
                }
                _log.info("updating delivery report " +subscriptionDeliveryRecord );
                subscriptionDeliveryRecordManager.saveOrUpdate(subscriptionDeliveryRecord);
               _log.info("Reporting undelivered report mail to admin and "+subscription.getSubscriber().getEmail());
                sendUndeliveredReport(subscription, subscriptionDeliveryRecord);
                return ResponseEntity.ok("ok");
            }else{
                return ResponseEntity.badRequest().body("redirect:/loginPage");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }

    }

    public void sendUndeliveredReport(Subscription subscription, SubscriptionDeliveryRecord subscriptionDeliveryRecord){
        Subscriber subscriber=subscription.getSubscriber();
        SubscriptionPlan subscriptionPlan = subscription.getSubscriptionPlan();
        Product product=subscriptionPlan.getProduct();
        _log.info("Sending Email about undelivered report to " + subscriber.getEmail());
        String[] recipients = {subscriber.getEmail(),"admin@madeintrees.com"};
        Mailer mailer = new Mailer();
        mailer.setRecipients(recipients);
        mailer.setSubject("Undelivered Report");
        HashMap<String, String> mailTemplateData = new HashMap<String, String>();
        mailTemplateData.put("userName", subscriber.getFirstName() + " " + subscriber.getLastName());
        mailTemplateData.put("productName", product.getProductName());
        mailTemplateData.put("date", (subscriptionDeliveryRecord.getDate().toString()).substring(0, 10));
        mailTemplateData.put("deliveryAddress", subscription.getDeliveryAddress().toString());
        mailTemplateData.put("templateName", "mailTemplates/undeliveredReport");
        mailService.prepareAndSend(mailer, mailTemplateData);
    }
}