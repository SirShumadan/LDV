package com.example.ldv.controller;


import com.example.ldv.domain.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getRestaurant(@PathVariable("id") long id, Model model){
        //implement method here
        return "";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable("id") long id){
        //implement method here
    }

    @RequestMapping(method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(Restaurant restaurant){
        //implement method here
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRestaurant(){
        //implement method here
    }

}
