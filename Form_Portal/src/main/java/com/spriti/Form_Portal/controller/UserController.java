package com.spriti.Form_Portal.controller;

import com.spriti.Form_Portal.dto.LogInUser;
import com.spriti.Form_Portal.entity.User;
import com.spriti.Form_Portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User user1 = userService.registerUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PostMapping("/logIn")
    public ResponseEntity<User> loggedInHandler(@RequestBody LogInUser credentials){
        User user = userService.loggedInUser(credentials.getEmail(), credentials.getPassword());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

