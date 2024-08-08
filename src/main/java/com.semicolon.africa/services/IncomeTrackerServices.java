package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.request.IncomeRequest;
import com.semicolon.africa.dtos.request.UpdateExpenseRequest;
import com.semicolon.africa.dtos.request.UpdateIncomeRequest;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.models.Income;
import com.semicolon.africa.repository.IncomeRepository;
import com.semicolon.africa.utility.ExpenseUtility;
import com.semicolon.africa.utility.IncomeUtility;
import com.semicolon.africa.values.Expenses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.africa.utility.ExpenseUtility.setExpenseToResponse;
import static com.semicolon.africa.utility.IncomeUtility.addRequestToIncome;
import static com.semicolon.africa.utility.IncomeUtility.setIncomeToResponse;
import static com.semicolon.africa.validations.ExpenseAmountValidation.validateMonth;
import static com.semicolon.africa.validations.IncomeAmountValidation.validateIncome;

@Service
public class IncomeTrackerServices {

    private final IncomeRepository repository;

    private IncomeTrackerServices(IncomeRepository repository){
        this.repository = repository;
    }

    public void addIncome(IncomeRequest request){
        validateIncome(request);
        validateMonth(request.getMonth());
        IncomeResponse response  = new IncomeResponse();
        Income income = addRequestToIncome(request);
        repository.save(income);
    }

    public DeleteIncomeResponse deleteIncomeRequest(IncomeRequest request){
        DeleteIncomeResponse response = new DeleteIncomeResponse();
        Income expensesToDelete = repository.findByMonth(request.getMonth());
        repository.delete(expensesToDelete);
        response.setMessage("Expense detail deleted successfully");
        return response;
    }

    public List<Income> getAllExpense(){
        return repository.findAll();
    }

    public UpdateIncomeResponse updateExpensesByMonth(UpdateIncomeRequest request){
        UpdateIncomeResponse response = new UpdateIncomeResponse();
        IncomeUtility utility = new IncomeUtility();
        Income income = new Income();
        repository.findByMonth(request.getMonth());
        income.setMonth(request.getMonth());
        income.setRentalIncome(request.getNewRentalIncome());
        income.setSalaryOrWages(request.getNewSalaryOrWages());
        income.setIncomeFromAssets(request.getNewIncomeFromAssets());
        income.setInvestmentIncome(request.getNewInvestmentIncome());
        income.setSideHustles(request.getNewSideHustles());
        income.setDescription(request.getNewDescription());
        income.setCustomIncome(request.getNewCustomIncome());
        income.setCustomIncomeAmount(request.getNewCustomIncomeAmount());
        income.setLocalDateTime(LocalDateTime.now());
        repository.save(income);
        return setIncomeToResponse(income);

    }

}
