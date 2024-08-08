package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.request.UpdateExpenseRequest;
import com.semicolon.africa.dtos.response.DeleteExpenseResponse;
import com.semicolon.africa.dtos.response.UpdateExpenseResponse;
import com.semicolon.africa.exceptions.MoneyValidationException;
import com.semicolon.africa.exceptions.MonthValidationException;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.values.Expenses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.africa.utility.ExpenseUtility.setExpenseToResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testToRetrieveAllExpensesForTheMonth(){
        ExpenseRequest request = createRequest();
        services.addExpensesToDashboard(request);
        List<Expenses> expensesList = services.getAllExpense();
        assertThat(expensesList.size()).isEqualTo(1L);
    }


    @Test
    void deleteExpensesByMonth() {
        ExpenseRequest request = createRequest();
        services.addExpensesToDashboard(request);
        DeleteExpenseResponse expensesToDelete = services.deleteExpensesByMonth(request);
        assertThat(expensesToDelete).isNotIn(repository);
    }

    @Test
    void updateExpensesByMonth(){
        ExpenseRequest createdRequest = createRequest();
        UpdateExpenseResponse expenseRequest = services.updateExpensesByMonth(newRequest());
        assertThat(createdRequest).isNotIn(repository);
    }

    @Test
    void testToThrowExceptionForValuesLessThan0(){
        ExpenseRequest request = createRequest();
        assertThrows(MoneyValidationException.class, ()-> services.addExpensesToDashboard(request));
    }

    @Test
    void testThatMonthInputtedIsValid(){
        ExpenseRequest request = createRequest();
        System.out.println(request.getMonth());
        assertThrows(MonthValidationException.class, ()-> services.addExpensesToDashboard(request));
    }

    private ExpenseRequest createRequest(){
        ExpenseRequest request = new ExpenseRequest();
        request.setMonth("february");
        request.setRent(200L);
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

    private UpdateExpenseRequest newRequest(){
        UpdateExpenseRequest request = new UpdateExpenseRequest();
        request.setMonth("july");
        request.setNewRent(2000L);
        request.setNewClothingExpenses(2000L);
        request.setNewFoodExpense(2000L);
        request.setNewTax(2000L);
        request.setNewFoodExpense(2000L);
        request.setNewTransportationFees(2000L);
        request.setNewMiscellaneous(2000L);
        request.setNewPersonalExpenses(2000L);
        request.setNewDescription("My expenses for the month of July");
        request.setNewLocalDateTime(LocalDateTime.now());
        request.setNewCustomExpense("My personal expense");
        request.setNewCustomExpensesAmount(2000L);
        return request;
    }
}