package com.semicolon.africa.models;

import com.semicolon.africa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testThatWeCanInputAnExpense(){

    }
}