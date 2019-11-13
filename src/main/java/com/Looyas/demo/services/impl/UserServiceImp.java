package com.looyas.demo.services.impl;

import com.looyas.demo.models.User;
import com.looyas.demo.repositories.UserRepository;
import com.looyas.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
   private UserRepository userRepository;

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
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

//    @Override
//    public void addUser(User user) {
//        List<User> userList = new ArrayList<User>();
//        userList.add(user);
//    }


}
