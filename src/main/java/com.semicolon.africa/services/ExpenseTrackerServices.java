package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.response.ExpenseResponse;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.utility.ExpenseUtility;
import com.semicolon.africa.values.Expenses;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTrackerServices {
    private final ExpenseRepository repository;

    private ExpenseTrackerServices(ExpenseRepository repository) {
        this.repository = repository;
    }


    public ExpenseResponse addExpensesToDashboard(ExpenseRequest request){
        ExpenseResponse response = new ExpenseResponse();
        ExpenseUtility utility = new ExpenseUtility();
        Expenses expenses = utility.addRequestToExpenses(request);
        repository.save(expenses);
        return response;
    }

    public void deleteExpensesByMonth(ExpenseRequest request) {
        ExpenseResponse response = new ExpenseResponse();
        ExpenseUtility utility = new ExpenseUtility();
        Expenses expenses = utility.addRequestToExpenses(request);
        repository.findByMonth(request.getMonth());
    }

    public void updateExpensesByMonth(ExpenseRequest request){

    }
}
