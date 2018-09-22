package com.example.ldv.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String accessDenied(Model model, Principal principal){
        if(principal != null){
            model.addAttribute("message", "Hello " + principal.getName() + "<br> You do not have permission to access this page!");
        }else{
            model.addAttribute("message", "You do not have permission to access this page!");
        }
        return "error403";
    }

    @RequestMapping(value="/logoutSuccessful", method=RequestMethod.GET)
    public String logoutPage(){
        return "logoutSuccessful";
    }
}
