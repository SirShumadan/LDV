package com.example.ldv.repository;

import com.example.ldv.domain.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    boolean delete(Long id);
    boolean save(Vote vote);
    List<Vote> findByDate(LocalDate date);
    List<Vote> findByUser(Long userId);
    Vote findByUserAndDate(Long userId, LocalDate date);
}
