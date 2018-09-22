package com.example.ldv.service;

import com.example.ldv.domain.Vote;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {
    Vote save(Vote vote);
    void delete(Long id);
    List<Vote> findByDate(LocalDate date);
    List<Vote> findByUser(Long userId);
    Vote findByUserAndDate(Long userId, LocalDate date);
}
