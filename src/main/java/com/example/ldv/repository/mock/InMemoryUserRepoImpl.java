package com.example.ldv.repository.mock;

import com.example.ldv.domain.User;
import com.example.ldv.repository.UserRepository;

public class InMemoryUserRepoImpl implements UserRepository {

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public User find(Long id) {
        return null;
    }
}
