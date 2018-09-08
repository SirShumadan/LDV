package com.example.ldv.repository.mock;

import com.example.ldv.domain.Vote;


public class InMemoryVoteRepoImpl{
    public void save(Vote vote) {
        System.out.println("Vote saved! ;>)");
    }
}
