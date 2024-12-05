package com.myproject.niit.SpringJUnitTest.service;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import com.myproject.niit.SpringJUnitTest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        user.setUserId(UUID.randomUUID().toString());

        User saved = userRepository.save(user);

        return saved;
    }

}
