package com.example.ldv.controller;


import com.example.ldv.domain.Dish;
import com.example.ldv.domain.Restaurant;
import com.example.ldv.service.DishService;
import com.example.ldv.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private RestaurantService restaurantService;
    private DishService dishService;

    @Autowired
    public RestaurantController(RestaurantService service, DishService dishService) {
        this.restaurantService = service;
        this.dishService = dishService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRestaurant(@PathVariable("id") long id,
                                Model model,
                                Principal principal) {
        log.info("User '{}' visit page '{}'", principal.getName(), "/" + id);
        model.addAttribute("restaurant", restaurantService.getRestaurantWithDishes(id));
        return "editing/restaurant";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRestaurant(@PathVariable("id") long id,
                                   Principal principal) {
        log.info("User '{}' delete restaurant id:{}", principal.getName(), id);
        restaurantService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String saveRestaurant(@RequestParam String restaurantName,
                                 Model model,
                                 @RequestParam String dishName0,
                                 @RequestParam String dishName1,
                                 @RequestParam Double dishPrice0,
                                 @RequestParam Double dishPrice1) {
        Restaurant rst = restaurantService.save(new Restaurant(restaurantName));
        log.info("Create new Restaurant name: {} id: {}", rst.getName(), rst.getId());
        if (dishName0 != null && dishPrice0 != null) {
            Dish d1 = dishService.save(new Dish(dishName0, dishPrice0, rst.getId()));
            log.info("Create new Dish name: {} price: {} id: {} for RestaurantId: {}",
                    d1.getName(),
                    d1.getPrice(),
                    d1.getId(),
                    d1.getRestaurantId());
        }
        if (dishName1 != null && dishPrice1 != null) {
            Dish d0 = dishService.save(new Dish(dishName1, dishPrice1, rst.getId()));
            log.info("Create new Dish name: {} price: {} id: {} for RestaurantId: {}",
                    d0.getName(),
                    d0.getPrice(),
                    d0.getId(),
                    d0.getRestaurantId());
        }
        model.addAttribute("id", rst.getId());
        return "redirect:/restaurant/{id}";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newRestaurant(Principal principal) {
        log.info("User '{}' visit page '/restaurant/new'", principal.getName());
        return "editing/newRestaurant";
    }


    @RequestMapping(value = "/{restaurantId}/dish/new", method = RequestMethod.GET)
    public String newDish(Model model,
                          @PathVariable long restaurantId,
                          Principal principal) {
        log.info("User '{}' visit page '/{}/dish/new'", principal.getName(), restaurantId);
        model.addAttribute("restaurantId", restaurantId);
        return "editing/newDish";
    }

    @RequestMapping(value = "/{restaurantId}/dish/save", method = RequestMethod.POST)
    public String saveDish(@RequestParam(required = false) Long id,
                           @RequestParam String name,
                           @RequestParam double price,
                           @PathVariable long restaurantId,
                           Principal principal) {
        if (id == null) {
            Dish d = dishService.save(new Dish(name, price, restaurantId));
            log.info("User '{}' create new Dish name: {} price: {} id: {} for RestaurantId: {}",
                    principal.getName(),
                    d.getName(),
                    d.getPrice(),
                    d.getId(),
                    restaurantId);
        } else {
            dishService.save(new Dish(id, name, price, restaurantId));
            log.info("User '{}' create new Dish name: {} price: {} id: {} for RestaurantId: {}",
                    principal.getName(),
                    name,
                    price,
                    id,
                    restaurantId);
        }
        return "redirect:/restaurant/{restaurantId}";
    }

    @RequestMapping(value = "/{restaurantId}/dish/delete/{id}", method = RequestMethod.GET)
    public String deleteDish(@PathVariable long id,
                             @PathVariable long restaurantId,
                             Principal principal) {
        log.info("User '{}' delete Dish {} id: {} from RestaurantId: {}",principal.getName(), id, restaurantId);
        dishService.delete(id);
        return "redirect:/restaurant/{restaurantId}";
    }

    @RequestMapping(value = "/{restaurantId}/dish/edit/{id}", method = RequestMethod.GET)
    public String editDish(Model model,
                           @PathVariable long id,
                           @PathVariable long restaurantId,
                           Principal principal) {
        log.info("User '{}' visit page '/{}/dish/edit/{}'", principal.getName(), restaurantId, id);
        model.addAttribute("restaurantId", restaurantId);
        model.addAttribute("dish", dishService.get(id));
        return "editing/editDish";
    }

}
