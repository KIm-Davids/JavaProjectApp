package com.semicolon.africa.dtos.response;

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
public class UpdateExpenseResponse {

    private String updatedDescription;
    private LocalDateTime updatedLocalDateTime;


    @Id
    private String month;
    private long UpdatedRent;
    private long UpdatedFoodExpense;
    private long UpdatedClothingExpenses;
    private long UpdatedTransportationFees;
    private long UpdatedTax;
    private long UpdatedMiscellaneous;
    private long UpdatedPersonalExpenses;
    private long UpdatedCustomExpensesAmount;
    private String UpdatedCustomExpense;
}
