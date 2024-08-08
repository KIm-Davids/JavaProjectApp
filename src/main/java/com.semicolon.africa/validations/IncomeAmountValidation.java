package com.semicolon.africa.validations;

import com.semicolon.africa.dtos.request.IncomeRequest;
import com.semicolon.africa.exceptions.MoneyValidationException;
import com.semicolon.africa.exceptions.MonthValidationException;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class IncomeAmountValidation {

    public static void validateIncome(IncomeRequest request){
        if(request.getInvestmentIncome() < 0 || request.getCustomIncomeAmount() < 0 || request.getRentalIncome() < 0 || request.getSideHustles() < 0 || request.getSalaryOrWages() < 0 || request.getIncomeFromAssets() < 0){
            throw new MoneyValidationException("Amount not valid");
        }
    }
}
