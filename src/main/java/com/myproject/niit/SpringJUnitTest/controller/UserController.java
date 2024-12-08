package com.myproject.niit.SpringJUnitTest.controller;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import com.myproject.niit.SpringJUnitTest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping(value = "/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable("userId") String userId,
            @RequestBody User user
    ) {

        User updatedUser = userService.updateUser(userId, user);

        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getAUser(
            @PathVariable("userId") String userId
    ) {

        User user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
}
