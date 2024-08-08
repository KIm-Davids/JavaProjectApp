package com.semicolon.africa.utility;

import com.semicolon.africa.dtos.request.IncomeRequest;
import com.semicolon.africa.dtos.response.UpdateExpenseResponse;
import com.semicolon.africa.dtos.response.UpdateIncomeResponse;
import com.semicolon.africa.models.Income;
import com.semicolon.africa.values.Expenses;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class IncomeUtility {

    public static Income addRequestToIncome(IncomeRequest request){
        Income income = new Income();
        income.setMonth(request.getMonth());
        income.setLocalDateTime(LocalDateTime.now());
        income.setDescription(request.getDescription());
        income.setSideHustles(request.getSideHustles());
        income.setInvestmentIncome(request.getInvestmentIncome());
        income.setRentalIncome(request.getRentalIncome());
        income.setCustomIncome(request.getCustomIncome());
        income.setCustomIncomeAmount(request.getCustomIncomeAmount());
        income.setIncomeFromAssets(request.getIncomeFromAssets());
        income.setInvestmentIncome(request.getInvestmentIncome());
        income.setSalaryOrWages(request.getSalaryOrWages());
        return income;
    }

    public static UpdateIncomeResponse setIncomeToResponse(Income income){
        UpdateIncomeResponse response = new UpdateIncomeResponse();
        response.setMonth(income.getMonth());
        response.setLocalDateTime(LocalDateTime.now());
        response.setUpdateDescription(income.getDescription());
        response.setUpdateInvestmentIncome(income.getInvestmentIncome());
        response.setUpdateRentalIncome(income.getRentalIncome());
        response.setUpdateCustomIncome(income.getCustomIncome());
        response.setUpdateCustomIncomeAmount(income.getCustomIncomeAmount());
        response.setUpdateIncomeFromAssets(income.getIncomeFromAssets());
        response.setUpdateSideHustles(income.getSideHustles());
        response.setUpdateSalaryOrWages(income.getSalaryOrWages());
        return response;
    }
}
