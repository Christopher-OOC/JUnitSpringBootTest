package com.myproject.niit.SpringJUnitTest.repository;

import com.myproject.niit.SpringJUnitTest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(String userId);


}
