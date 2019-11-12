package com.looyas.demo.services;

import com.looyas.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    void deleteById(String userId);

    void addUser(User user);

    Iterable<User> findAll();

    Optional<User> findById(String userId);

    User save(User user);
}


