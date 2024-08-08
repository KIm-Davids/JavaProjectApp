package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.request.UpdateExpenseRequest;
import com.semicolon.africa.dtos.response.DeleteExpenseResponse;
import com.semicolon.africa.dtos.response.ExpenseResponse;
import com.semicolon.africa.dtos.response.UpdateExpenseResponse;
import com.semicolon.africa.repository.ExpenseRepository;
import com.semicolon.africa.utility.ExpenseUtility;
import com.semicolon.africa.values.Expenses;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.africa.utility.ExpenseUtility.setExpenseToResponse;
import static com.semicolon.africa.validations.ExpenseAmountValidation.validateAmount;
import static com.semicolon.africa.validations.ExpenseAmountValidation.validateMonth;

@Service
public class ExpenseTrackerServices {
    private final ExpenseRepository repository;

    private ExpenseTrackerServices(ExpenseRepository repository) {
        this.repository = repository;
    }


    public ExpenseResponse addExpensesToDashboard(ExpenseRequest request){
        validateAmount(request);
        validateMonth(request.getMonth());
        ExpenseResponse response = new ExpenseResponse();
        ExpenseUtility utility = new ExpenseUtility();
        Expenses expenses = utility.addRequestToExpenses(request);
        repository.save(expenses);
        return response;
    }

    public List<Expenses> getAllExpense(){
        return repository.findAll();
    }

    public DeleteExpenseResponse deleteExpensesByMonth(ExpenseRequest request) {
        DeleteExpenseResponse response = new DeleteExpenseResponse();
        Expenses expensesToDelete = repository.findByMonth(request.getMonth());
        repository.delete(expensesToDelete);
        response.setMessage("Expense detail deleted successfully");
        return response;
    }

    public UpdateExpenseResponse updateExpensesByMonth(UpdateExpenseRequest request){
        UpdateExpenseResponse response = new UpdateExpenseResponse();
        ExpenseUtility utility = new ExpenseUtility();
            Expenses expenses = new Expenses();
            ExpenseRequest oldRequest = new ExpenseRequest();
            repository.findByMonth(request.getMonth());
            expenses.setMonth(request.getMonth());
            expenses.setFoodExpense(request.getNewFoodExpense());
            expenses.setRent(request.getNewRent());
            expenses.setMiscellaneous(request.getNewMiscellaneous());
            expenses.setClothingExpenses(request.getNewClothingExpenses());
            expenses.setTax(request.getNewTax());
            expenses.setPersonalExpenses(request.getNewPersonalExpenses());
            expenses.setTransportationFees(request.getNewTransportationFees());
            expenses.setDescription(request.getNewDescription());
            expenses.setLocalDateTime(LocalDateTime.now());
            expenses.setCustomExpense(request.getNewCustomExpense());
            expenses.setCustomExpensesAmount(request.getNewCustomExpensesAmount());
            repository.save(expenses);
        return setExpenseToResponse(expenses);

    }
}
