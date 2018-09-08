package com.example.ldv.repository;

import com.example.ldv.domain.Vote;

import java.time.LocalDate;

public interface VoteRepository {
    public boolean delete(Long id);
    void save(Vote vote);
    Vote findByDate(LocalDate date);
    Vote findByUserId(Long userId);
    Vote findByUserAndDate(Long userId, LocalDate date);
}
