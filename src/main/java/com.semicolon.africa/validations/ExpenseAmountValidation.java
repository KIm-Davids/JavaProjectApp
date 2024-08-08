package com.semicolon.africa.validations;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.exceptions.MoneyValidationException;
import com.semicolon.africa.exceptions.MonthValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseAmountValidation {

    private long amount;

    public static void validateAmount(ExpenseRequest request) {
        if (request.getTax() < 0 || request.getFoodExpense() < 0 || request.getMiscellaneous() < 0 || request.getPersonalExpenses() < 0 || request.getTransportationFees() < 0 || request.getClothingExpenses() < 0 || request.getCustomExpensesAmount() < 0 || request.getRent() < 0) {
            throw new MoneyValidationException("Amount not valid");
        }

    }

    public static void validateMonth(String request){
        String[] monthsOfTheYear = {
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
        };

        if(!Arrays.stream(monthsOfTheYear).toList().contains(request.toUpperCase())) throw new MonthValidationException("Invalid Month");
    }
}
