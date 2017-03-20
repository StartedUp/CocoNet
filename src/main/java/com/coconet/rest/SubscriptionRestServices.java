package com.coconet.rest;

import com.coconet.util.SubscriptionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.FormParam;
import java.math.BigDecimal;

/**
 * Created by Prithu on 18-03-2017.
 */
@RestController
public class SubscriptionRestServices {
    @RequestMapping(value = "/subscription/getTotalPrice", method = RequestMethod.GET)
    public ResponseEntity<String> calculateTotalPrice(@RequestParam("pricePerUnit")BigDecimal pricePerUnit, @RequestParam("totalQuantity")BigDecimal totalQuantity){
        BigDecimal totalPrice=SubscriptionUtil.priceCalculator(totalQuantity, pricePerUnit);
        return ResponseEntity.ok(totalPrice+"");
    }
}
