package com.example.ldv.controller;
import com.example.ldv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private RestaurantService restaurantService;

    @Autowired
    public MainController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/")
    public String showHomePage(){
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("restaurants", restaurantService.restaurantsWithDishes());
        return "editing/admin";
    }

}
