package com.semicolon.africa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRequest {

    private LocalDateTime localDateTime;

    @Id
    private String month;
    private long salaryOrWages;
    private long sideHustles;
    private long investmentIncome;
    private long rentalIncome;
    private String description;
    private String customIncome;
    private long customIncomeAmount;
    private long incomeFromAssets;
}
