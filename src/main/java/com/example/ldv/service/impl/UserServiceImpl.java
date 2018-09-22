package com.example.ldv.service.impl;

import com.example.ldv.domain.User;
import com.example.ldv.repository.UserRepository;
import com.example.ldv.service.UserService;
import com.example.ldv.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String login) {
        return userRepository.findById(1L).orElseThrow(() -> new UserNotFoundException(login));
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
