package com.coconet.mit.customerPortal.rest;

import com.coconet.mit.commons.model.*;
import com.coconet.mit.customerPortal.service.MailService;
import com.coconet.mit.customerPortal.service.SubscriptionDeliveryRecordManager;
import com.coconet.mit.customerPortal.service.SubscriptionManager;
import com.coconet.mit.customerPortal.service.SubscriptionPlanManager;
import com.coconet.mit.customerPortal.util.Mailer;
import com.coconet.mit.customerPortal.util.SubscriptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private SubscriptionPlanManager subscriptionPlanManager;
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

    @RequestMapping(value = "/subscription/getEndDate", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getEndDate(@RequestParam("startDate") Date startDate, @RequestParam("subscriptionPlanId") int subscriptionPlanId) {
        SubscriptionPlan subscriptionPlan=subscriptionPlanManager.getSubscriptionPlan(subscriptionPlanId);
        _log.info("startDate "+startDate+" subscriptionPlanId "+subscriptionPlan);
        Subscription subscription = SubscriptionUtil.startAndEndDateSetter(new Subscription(), subscriptionPlan, startDate);
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String endDate = df.format(subscription.getEndDate());
        return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
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
        Product product=subscription.getProduct();
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