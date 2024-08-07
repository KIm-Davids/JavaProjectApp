package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.values.Expenses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExpenseTrackerServicesTest {

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private ExpenseTrackerServices services;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    public void testThatExpensesAreSaved() {
        ExpenseRequest request = createRequest();
        services.addExpensesToDashboard(request);
        assertThat(repository).isNotNull();
    }

    @Test
    void deleteExpensesByMonth() {
        ExpenseRequest request = createRequest();
        services.addExpensesToDashboard(request);
        Expenses expensesToDelete = repository.findByMonth("july");
        repository.delete(expensesToDelete);
        assertThat(expensesToDelete).isNotIn(repository);
    }

    @Test
    void updateExpensesByMonth(){

    }

    private ExpenseRequest createRequest(){
        ExpenseRequest request = new ExpenseRequest();
        request.setMonth("july");
        request.setRent(1000L);
        request.setClothingExpenses(1000L);
        request.setFoodExpense(1000L);
        request.setTax(1000L);
        request.setFoodExpense(1000L);
        request.setTransportationFees(1000L);
        request.setMiscellaneous(1000L);
        request.setPersonalExpenses(1000L);
        request.setDescription("My expenses for the month of July");
        request.setLocalDateTime(LocalDateTime.now());
        request.setCustomExpense("My personal expense");
        request.setCustomExpensesAmount(1000L);
        return request;
    }



}