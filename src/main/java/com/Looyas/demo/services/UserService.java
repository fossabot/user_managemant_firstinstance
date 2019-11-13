package com.looyas.demo.services;

import com.looyas.demo.models.User;

import java.util.Optional;

public interface UserService {
    void deleteById(String userId);

    Iterable<User> findAll();

    Optional<User> findById(String userId);

    User add(User user);
}


