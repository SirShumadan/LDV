package com.example.ldv.repository;

import com.example.ldv.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    boolean delete(Long id);
    boolean save(User user);
    User find(Long id);
}
