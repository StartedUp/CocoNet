package com.coconet.mit.customerPortal.rest;

import com.coconet.mit.customerPortal.model.Address;
import com.coconet.mit.customerPortal.model.LoggedInSubscriber;
import com.coconet.mit.customerPortal.model.Subscriber;
import com.coconet.mit.customerPortal.service.SubscriberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${Prithu} on 12-02-2017.
 */
@RestController
@RequestMapping("rest")
public class SubscriberRestServices {
    @Autowired
    private SubscriberManager subscriberManager;

    private static final Log _log = LogFactory.getLog(SubscriberRestServices.class);

    @RequestMapping(value= "/subscriberEmailCheck", method = RequestMethod.GET)
    public ResponseEntity subscriberEmailCheck(@RequestParam("email") String email){
        Subscriber checkSubscriber= subscriberManager.findByEmail(email);
        return checkSubscriber!=null?ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This email is registered already"):ResponseEntity.ok(null);
    }
    @RequestMapping(value = "/subscriberAddAddress", method = RequestMethod.POST)
    public ResponseEntity<Address> subscriberAddAddress(@RequestBody Address address) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            LoggedInSubscriber loggedInSubscriber = (LoggedInSubscriber) auth.getPrincipal();
            _log.info("@@RequestBody " + address);
            Subscriber subscriber = subscriberManager.findByEmail(loggedInSubscriber.getEmail());
            if (address.getAddressHolderName() == null) {
                address.setAddressHolderName(subscriber.getFirstName());
            }
            address.setSubscriber(subscriber);
            subscriber.getAddresses().add(address);
            subscriberManager.saveOrUpdate(subscriber);
            _log.info("Subscriber address:" + address);
            return new ResponseEntity<Address>(address, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}
