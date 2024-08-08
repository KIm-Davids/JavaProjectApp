package com.semicolon.africa.utility;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.request.UpdateExpenseRequest;
import com.semicolon.africa.dtos.response.UpdateExpenseResponse;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.values.Expenses;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ExpenseUtility {

    private ExpenseRepository repository;

    public ExpenseUtility(ExpenseRepository repository) {
        this.repository = repository;
    }

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


    public static UpdateExpenseResponse setExpenseToResponse(Expenses expenses){
        UpdateExpenseResponse response = new UpdateExpenseResponse();
        response.setMonth(expenses.getMonth());
        response.setUpdatedFoodExpense(expenses.getFoodExpense());
        response.setUpdatedRent(expenses.getRent());
        response.setUpdatedMiscellaneous(expenses.getMiscellaneous());
        response.setUpdatedClothingExpenses(expenses.getClothingExpenses());
        response.setUpdatedTax(expenses.getTax());
        response.setUpdatedPersonalExpenses(expenses.getPersonalExpenses());
        response.setUpdatedTransportationFees(expenses.getTransportationFees());
        response.setUpdatedDescription(expenses.getDescription());
        response.setUpdatedLocalDateTime(LocalDateTime.now());
        response.setUpdatedCustomExpense(expenses.getCustomExpense());
        response.setUpdatedCustomExpensesAmount(expenses.getCustomExpensesAmount());
        return response;
    }

}
