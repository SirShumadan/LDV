package com.example.ldv.controller;
import com.example.ldv.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private RestaurantService restaurantService;

    @Autowired
    public MainController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/")
    public String showHomePage(Principal principal){
        String userName;
        if(principal == null){
            userName = "Anonymous";
        }else {
            userName = principal.getName();
        }
        log.info("User '{}' visit page '/'", userName);
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal){
        log.info("User '{}' visit page '/admin'", principal.getName());
        model.addAttribute("restaurants", restaurantService.restaurantsWithDishes());
        return "editing/admin";
    }

}
