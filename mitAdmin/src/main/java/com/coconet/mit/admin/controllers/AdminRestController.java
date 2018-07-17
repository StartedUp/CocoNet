package com.coconet.mit.admin.controllers;

import com.coconet.mit.admin.service.ProductManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Balaji on 8/7/18.
 */
@RestController
public class AdminRestController {
    private static final Logger LOGGER= LoggerFactory.getLogger(AdminRestController.class.getName());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(value = "/manage-product", method = RequestMethod.GET)
    public ResponseEntity manageProducts(@RequestParam("productId") int ProductId, @RequestParam("active") boolean active){
        productManager.updateById(ProductId, active);
        return ResponseEntity.ok("Product has been updated successfully");
    }


}
