package com.myproject.niit.SpringJUnitTest.service;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import com.myproject.niit.SpringJUnitTest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        user.setUserId(UUID.randomUUID().toString());
        user.setEnabled(true);

        User saved = userRepository.save(user);

        return saved;
    }

    public User updateUser(String userId, User userUpdate) {

        User existingUser = userRepository.findByUserId(userId);

        if (userUpdate.getFirstName() != null) {
            existingUser.setFirstName(userUpdate.getFirstName());
        }
        if (userUpdate.getLastName() != null) {
            existingUser.setLastName(userUpdate.getLastName());
        }
        if (userUpdate.getDateOfBirth() != null) {
            existingUser.setDateOfBirth(userUpdate.getDateOfBirth());
        }
        if (userUpdate.getEmail() != null) {
            existingUser.setEmail(userUpdate.getEmail());
        }
        if (userUpdate.getPassword() != null) {
            existingUser.setPassword(userUpdate.getPassword());
        }

        User savedUser = userRepository.save(existingUser);

        return savedUser;
    }

    public User getUser(String userId) {

        return userRepository.findByUserId(userId);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
