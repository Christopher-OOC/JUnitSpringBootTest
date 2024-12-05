package com.myproject.niit.SpringJUnitTest.controller;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import com.myproject.niit.SpringJUnitTest.service.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("It is working...");
    }

    @PostMapping
    public ResponseEntity<?> createANewUser(@RequestBody User user) {

        User createdUser = userService.createUser(user);

        return ResponseEntity.created(null).body(createdUser);
    }





}
