package com.looyas.demo.controllers;

import com.looyas.demo.models.User;
import com.looyas.demo.services.UserService;
import com.looyas.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    AuthenticationManager authenticationManager;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    //get all users
    @GetMapping("/getUsers")
    public ResponseEntity<Iterable<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/saveUser")
    public ResponseEntity create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }


    @GetMapping("/getUser/{userId}")

    public ResponseEntity<User> findById(@PathVariable String userId) throws ResourceNotFoundException {
        Optional<User> user = userService.findById(userId);
        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> update(@PathVariable("userId") String userId, @Valid User user,
                                       BindingResult result) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) throws ResourceNotFoundException {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }


}
