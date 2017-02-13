package com.coconet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 17-12-2016.
 */
@Controller
public class WebAppHomeController {
    @RequestMapping("/")
    public String webAppHome(){
        return "webAppHome";
    }
    @RequestMapping("/loginPage")
    public  String loginPage(){
        return "loginPage";
    }
    @RequestMapping("/signupPage")
    public String signupPage() {
        return "signupPage";
    }
}
