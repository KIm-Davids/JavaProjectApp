package com.semicolon.africa.repository;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.models.User;
import com.semicolon.africa.services.ExpenseTrackerServices;
import com.semicolon.africa.values.Expenses;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private ExpenseTrackerServices services;

    @BeforeEach
    void clearData(){
        repository.deleteAll();
    }

    @Test
    public void testThatRepositoryCanSave(){
        Expenses expense = new Expenses();
        repository.save(expense);
        assertThat(repository.count()).isEqualTo(1);
    }

}