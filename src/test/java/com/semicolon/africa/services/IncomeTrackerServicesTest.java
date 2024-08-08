package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.request.IncomeRequest;
import com.semicolon.africa.dtos.request.UpdateExpenseRequest;
import com.semicolon.africa.dtos.request.UpdateIncomeRequest;
import com.semicolon.africa.dtos.response.UpdateExpenseResponse;
import com.semicolon.africa.dtos.response.UpdateIncomeResponse;
import com.semicolon.africa.models.Income;
import com.semicolon.africa.repository.IncomeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IncomeTrackerServicesTest {

    @Autowired
    private IncomeRepository repository;

    @Autowired
    private IncomeTrackerServices services;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    void testThatWeCanAddIncomeToTheRepository() {
        IncomeRequest income  = generateIncome();
        services.addIncome(income);
        assertThat(repository).isNotNull();
    }

    @Test
    void updateIncomeByMonth(){
        IncomeRequest createdRequest = generateIncome();
        UpdateIncomeResponse expenseRequest = services.updateExpensesByMonth(newRequest());
        assertThat(createdRequest).isNotIn(repository);
    }

    private IncomeRequest generateIncome(){
        IncomeRequest request = new IncomeRequest();
        request.setMonth("january");
        request.setDescription("Income for the month of july");
        request.setCustomIncomeAmount(1000L);
        request.setCustomIncome("Overdraft");
        request.setRentalIncome(1000L);
        request.setIncomeFromAssets(1000L);
        request.setSideHustles(1000L);
        request.setSalaryOrWages(1000L);
        request.setInvestmentIncome(1000L);
        request.setLocalDateTime(LocalDateTime.now());
        return request;
    }

    private UpdateIncomeRequest newRequest(){
        UpdateIncomeRequest request = new UpdateIncomeRequest();
        request.setMonth("JANUARY");
        request.setNewDescription("Income for the month of August");
        request.setNewCustomIncomeAmount(2000L);
        request.setNewCustomIncome("Income from Asset");
        request.setNewRentalIncome(2000L);
        request.setNewIncomeFromAssets(2000L);
        request.setNewSideHustles(2000L);
        request.setNewSalaryOrWages(2000L);
        request.setNewInvestmentIncome(2000L);
        request.setLocalDateTime(LocalDateTime.now());
        return request;
    }
}