package com.myproject.niit.SpringJUnitTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.niit.SpringJUnitTest.model.entity.User;
import com.myproject.niit.SpringJUnitTest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    User user;

    @MockBean
    UserService userService;

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
    void testCreateUser() throws Exception {

        String contentBody = new ObjectMapper().writeValueAsString(user);

        user.setId(1);
        Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(
                post("/api/users")
                        .content(contentBody)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.firstName", is(user.getFirstName())))
                .andDo(print());



    }
}
