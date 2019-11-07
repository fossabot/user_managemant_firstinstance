package com.Looyas.demo.services;

import com.Looyas.demo.models.User;

import java.util.Optional;

public interface UserService {
    void deleteById(String userId);
    void addUser(User user);
    Iterable<User> findAll();
    Optional<User> findById(String userId);
    User save(User user);
}


