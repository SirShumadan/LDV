package com.example.ldv.controller;

import com.example.ldv.domain.Vote;
import com.example.ldv.service.RestaurantService;
import com.example.ldv.service.VoteService;
import com.example.ldv.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping(value = "/voting")
public class VotingController {
    private RestaurantService restaurantService;
    private VoteService voteService;

    @Autowired
    public VotingController(RestaurantService restaurantService, VoteService voteService) {
        this.restaurantService = restaurantService;
        this.voteService = voteService;
    }

    //return voting page
    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentVoting(Map<String, Object> model) {
        model.put("restaurants", restaurantService.restaurantsWithDishes());
        return "voting";
    }

    //saveAndFlush user vote
    @RequestMapping(method = RequestMethod.POST, value = "/vote")
    public String saveVote(@RequestParam Long restaurantId) {
        long userId = SecurityUtil.getUserId();
        Vote vote = new Vote(userId, restaurantId, LocalDate.now());
        voteService.save(vote);
        return "redirect:/";
    }
}
