package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateIncomeResponse {

    private LocalDateTime localDateTime;

    @Id
    private String month;
    private long updateSalaryOrWages;
    private long updateSideHustles;
    private long updateInvestmentIncome;
    private long updateRentalIncome;
    private String updateDescription;
    private long updateIncomeFromAssets;
    private String updateCustomIncome;
    private long updateCustomIncomeAmount;
}
