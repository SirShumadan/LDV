package com.example.ldv.service.impl;


import com.example.ldv.domain.Vote;
import com.example.ldv.repository.VoteRepository;
import com.example.ldv.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.ldv.util.SecurityUtil.getUserId;
import static com.example.ldv.util.TimeUtil.currentDate;
import static com.example.ldv.util.TimeUtil.isVoteCanBeChanged;

@Service
public class VoteServiceImpl implements VoteService {
    private VoteRepository repo;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepo) {
        this.repo = voteRepo;
    }

    public Vote save(Vote vote){
        Vote v = repo.findByUserIdAndCreatedDate(getUserId(), currentDate());
        if(v != null) {
            if(!isVoteCanBeChanged()){
                return v;
            }
            vote.setId(v.getId());
        }
        return repo.saveAndFlush(vote);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<Vote> findByDate(LocalDate date){
        return repo.findByCreatedDate(date);
    }

    public List<Vote> findByUser(Long userId){
        return repo.findByUserId(userId);
    }

    public Vote findByUserAndDate(Long userId, LocalDate date){
        return repo.findByUserIdAndCreatedDate(userId, date);
    }


}
