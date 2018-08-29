package com.example.ldv.controller;

import com.example.ldv.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value="/voting")
public class VotingController {
    private RestaurantRepository repo;

    @Autowired
    public VotingController(RestaurantRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String voting(Map<String, Object> model){
        model.put("restaurants", repo.getRestaurants());
        return "voting";
    }

    //save vote before user
    public void saveVote(){

    }

}
