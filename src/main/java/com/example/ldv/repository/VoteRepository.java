package com.example.ldv.repository;

import com.example.ldv.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByCreatedDate(LocalDate date);
    List<Vote> findByUserId(Long userId);
    Vote findByUserIdAndCreatedDate(Long userId, LocalDate date);
}
