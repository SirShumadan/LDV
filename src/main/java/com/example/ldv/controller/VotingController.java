package com.example.ldv.controller;

import com.example.ldv.domain.Vote;
import com.example.ldv.repository.RestaurantRepository;
import com.example.ldv.repository.VoteRepository;
import com.example.ldv.service.VoteService;
import com.example.ldv.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping(value="/voting")
public class VotingController {
    private RestaurantRepository restaurantRepo;
    private VoteService voteService;

    @Autowired
    public VotingController(RestaurantRepository repo, VoteService voteService) {
        this.restaurantRepo = repo;
        this.voteService = voteService;
    }

    //return voting page
    @RequestMapping(method=RequestMethod.GET)
    public String getCurrentVoting(Map<String, Object> model){
        model.put("restaurants", restaurantRepo.findAll());
        return "voting";
    }

    //save user vote
    @RequestMapping(method=RequestMethod.POST, value="/vote")
    public String saveVote(@RequestParam Long restaurantId){
        long userId = SecurityUtil.getUserId();
        Vote vote = new Vote(userId, restaurantId, LocalDate.now());
        voteService.save(vote);
        return "redirect:/";
    }
}
