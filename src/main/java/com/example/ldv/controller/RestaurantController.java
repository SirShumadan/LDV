package com.example.ldv.controller;


import com.example.ldv.domain.Dish;
import com.example.ldv.domain.Restaurant;
import com.example.ldv.service.DishService;
import com.example.ldv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService restaurantService;
    private DishService dishService;

    @Autowired
    public RestaurantController(RestaurantService service, DishService dishService) {
        this.restaurantService = service;
        this.dishService = dishService;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getRestaurant(@PathVariable("id") long id, Model model){
        model.addAttribute("restaurant", restaurantService.getRestaurantWithDishes(id));
        return "editing/restaurant";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteRestaurant(@PathVariable("id") long id){
        restaurantService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String createRestaurant(Restaurant restaurant, RedirectAttributes redirectAttributes){
        Restaurant r = restaurantService.save(restaurant);
        redirectAttributes.addAttribute("id", r.getId());
        return "redirect:/restaurant";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void updateRestaurant(@PathVariable long id, Model model){
//        implement method here
    }


    @RequestMapping(value="/{restaurantId}/dish/new", method=RequestMethod.GET)
    public String newDish(Model model,@PathVariable long restaurantId){
        model.addAttribute("restaurantId", restaurantId);
        return "editing/newDish";
    }

    @RequestMapping(value="/{restaurantId}/dish/save", method=RequestMethod.POST)
    public String saveDish(@RequestParam(required=false) Long id ,@RequestParam String name, @RequestParam double price, @PathVariable long restaurantId){
        if(id==null){
            dishService.save(new Dish(name, price, restaurantId));
        }else{
            dishService.save(new Dish(id, name, price, restaurantId));
        }
        return "redirect:/restaurant/{restaurantId}";
    }

    @RequestMapping(value="/{restaurantId}/dish/delete/{id}", method=RequestMethod.GET)
    public String deleteDish(@PathVariable long id){
        dishService.delete(id);
        return "redirect:/restaurant/{restaurantId}";
    }

    @RequestMapping(value="/{restaurantId}/dish/edit/{id}", method=RequestMethod.GET)
    public String editDish(Model model, @PathVariable long id, @PathVariable long restaurantId){
        model.addAttribute("restaurantId", restaurantId);
        model.addAttribute("dish", dishService.get(id));
        return "editing/editDish";
    }

}
