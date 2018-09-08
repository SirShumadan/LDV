package com.example.ldv.service;


import com.example.ldv.domain.Vote;
import com.example.ldv.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private VoteRepository voteRepo;

    @Autowired
    public VoteService(VoteRepository voteRepo) {
        this.voteRepo = voteRepo;
    }

    public void save(Vote vote){
        voteRepo.save(vote);
    }
}
