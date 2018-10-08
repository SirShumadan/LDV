package com.example.ldv.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model,
                               Principal principal,
                               HttpServletRequest request) {
        if (principal != null) {
            model.addAttribute("message", "Hello " + principal.getName() + "<br> You do not have permission to access this page!");
            log.info("Denied permission to access page '{}' for user '{}'", request.getRequestURL(), principal.getName());
        } else {
            model.addAttribute("message", "You do not have permission to access this page!");
            log.info("Denied permission to access page '{}' for anonymous user", request.getRequestURL());
        }
        return "parts/error403";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutPage() {
        return "parts/logoutSuccessful";
    }
}
