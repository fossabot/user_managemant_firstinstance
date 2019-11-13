package com.looyas.demo.controllers;

import com.looyas.demo.models.User;
import com.looyas.demo.services.UserService;
import com.looyas.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get all users
    @GetMapping("/getUsers")
    public Iterable<User> getAllUsers() {
        return(userService.findAll());
    }

    //getUserById
    @GetMapping("/getUser/{userId}")
    public Optional<User> getUserByID(@PathVariable String userId)  {
        return   (userService.findById(userId));

    }
    //add user
    @PostMapping("/addUser")
    public User addUser( @RequestBody User user) {
        return (  userService.add(user));
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<User> update(@PathVariable("userId") String userId, @Valid User user,
                                       BindingResult result) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.add(user));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) throws ResourceNotFoundException {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }


}
