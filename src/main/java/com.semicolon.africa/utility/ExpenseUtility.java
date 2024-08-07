package com.semicolon.africa.utility;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.values.Expenses;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class ExpenseUtility {

    private ExpenseRepository repository;

    public Expenses addRequestToExpenses(ExpenseRequest request){
        Expenses expenses = new Expenses();
        expenses.setMonth(request.getMonth());
        expenses.setFoodExpense(request.getFoodExpense());
        expenses.setRent(request.getRent());
        expenses.setMiscellaneous(request.getMiscellaneous());
        expenses.setClothingExpenses(request.getClothingExpenses());
        expenses.setTax(request.getTax());
        expenses.setPersonalExpenses(request.getPersonalExpenses());
        expenses.setTransportationFees(request.getTransportationFees());
        expenses.setDescription(request.getDescription());
        expenses.setLocalDateTime(LocalDateTime.now());
        expenses.setCustomExpense(request.getCustomExpense());
        expenses.setCustomExpensesAmount(request.getCustomExpensesAmount());
        return expenses;
    }

}
