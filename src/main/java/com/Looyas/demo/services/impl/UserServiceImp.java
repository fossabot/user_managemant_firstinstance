package com.Looyas.demo.services.impl;

import com.Looyas.demo.models.User;
import com.Looyas.demo.repositories.UserRepository;
import com.Looyas.demo.services.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
   @Autowired
    public final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void addUser(User user) {
        List<User> userList = new ArrayList<User>();
        userList.add(user);
    }


}
