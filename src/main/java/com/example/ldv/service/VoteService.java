package com.example.ldv.service;


import com.example.ldv.domain.Vote;
import com.example.ldv.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.ldv.util.SecurityUtil.getUserId;
import static com.example.ldv.util.TimeUtil.currentDate;
import static com.example.ldv.util.TimeUtil.isVoteCanBeChanged;


@Service
public class VoteService {
    private VoteRepository repo;

    @Autowired
    public VoteService(VoteRepository voteRepo) {
        this.repo = voteRepo;
    }

    public boolean save(Vote vote){
        Vote v = repo.findByUserAndDate(getUserId(), currentDate());
        if(v != null) {
            if(!isVoteCanBeChanged()){
                return false;
            }
            vote.setId(v.getId());
        }
        return repo.save(vote);
    }

    public boolean delete(Long id){
        return repo.delete(id);
    }

    public List<Vote> findByDate(LocalDate date){
        return repo.findByDate(date);
    }

    public List<Vote> findByUser(Long userId){
        return repo.findByUser(userId);
    }

    public Vote findByUserAndDate(Long userId, LocalDate date){
        return repo.findByUserAndDate(userId, date);
    }


}
