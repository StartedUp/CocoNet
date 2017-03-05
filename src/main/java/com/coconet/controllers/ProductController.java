package com.coconet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prithu on 02-03-2017.
 */
@Controller
public class ProductController{
    @RequestMapping(value = "product")
    public String showProductDetails(){
        return "product-details";
    }
}
