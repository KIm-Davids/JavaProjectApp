package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateIncomeRequest {

    private LocalDateTime localDateTime;

    @Id
    private String month;
    private long newSalaryOrWages;
    private long newSideHustles;
    private long newInvestmentIncome;
    private long newRentalIncome;
    private String newDescription;
    private long newIncomeFromAssets;
    private String newCustomIncome;
    private long newCustomIncomeAmount;
}
