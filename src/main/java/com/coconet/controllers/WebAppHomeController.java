package com.coconet.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @RequestMapping("/welcome")
    public String welcomeHome(){
        return "webAppHome";
    }
    @RequestMapping("/loginPage")
    public  String loginPage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
    /* The user is logged in :) */
            return "redirect:/welcome?loggedin=true";
        }
        return "loginPage";
    }
    @RequestMapping("/signupPage")
    public String signupPage() {
        return "signupPage";
    }
}
