package com.example.ldv.service.impl;

import com.example.ldv.domain.User;
import com.example.ldv.repository.UserRepository;
import com.example.ldv.service.UserService;
import com.example.ldv.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUser(String login) {
        User user = userRepository.findByEmail(login);
        if (user == null) {
            throw new NotFoundException("User " + login + "is not found.");
        }
        return user;
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
