package com.coconet.rest;

import com.coconet.model.Subscriber;
import com.coconet.service.SubscriberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
