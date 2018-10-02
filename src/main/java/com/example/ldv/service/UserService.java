package com.example.ldv.service;

import com.example.ldv.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User getUser(String login);
    void delete(Long userId);
    User save(User user);
    User get(Long id);
}
