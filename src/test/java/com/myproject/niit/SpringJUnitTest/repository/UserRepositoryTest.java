package com.myproject.niit.SpringJUnitTest.repository;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user;


    @BeforeEach
    void setUpStubs() {

        user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("test@test.com");
        user.setPassword("password");
        user.setDateOfBirth(new Date());
        user.setEnabled(true);
    }

    @Test
    void testCreateUser_Success() {

        User saved = userRepository.save(user);

        assertNotNull(saved);
        assertEquals(1, user.getId());
    }



}
