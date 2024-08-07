package com.semicolon.africa.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expenses {
    private String month;
    private String description;
    private LocalDateTime localDateTime;

    @Id
    private String id;
    private long rent;
    private long foodExpense;
    private long clothingExpenses;
    private long transportationFees;
    private long tax;
    private long miscellaneous;
    private long personalExpenses;
    private String customExpense;
    private long customExpensesAmount;

}
