package com.example.ldv.controller;

import com.example.ldv.domain.Vote;
import com.example.ldv.service.RestaurantService;
import com.example.ldv.service.UserService;
import com.example.ldv.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping(value = "/voting")
public class VotingController {
    private static final Logger log = LoggerFactory.getLogger(VotingController.class);

    private RestaurantService restaurantService;
    private VoteService voteService;
    private UserService userService;

    @Autowired
    public VotingController(RestaurantService restaurantService, VoteService voteService, UserService userService) {
        this.restaurantService = restaurantService;
        this.voteService = voteService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentVoting(Map<String, Object> model,
                                   Principal principal) {
        log.info("User '{}' visit page '/voting'.", principal.getName());
        model.put("restaurants", restaurantService.restaurantsWithDishes());
        return "voting";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vote")
    public String saveVote(@RequestParam Long restaurantId,
                           Principal principal) {
        log.info("User '{}' has voted for the restaurant '{}'.", principal.getName(), restaurantId);
        long userId = userService.getUser(principal.getName()).getId();
        Vote vote = new Vote(userId, restaurantId, LocalDate.now());
        voteService.save(vote);
        return "redirect:/";
    }
}
