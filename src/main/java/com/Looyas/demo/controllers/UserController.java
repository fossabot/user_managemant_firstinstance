package com.Looyas.demo.controllers;

import com.Looyas.demo.exceptions.ResourceNotFoundException;
import com.Looyas.demo.models.User;
import com.Looyas.demo.repositories.UserRepository;
import com.Looyas.demo.services.UserService;
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
    public ResponseEntity<Iterable<User>> findAll() {
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
