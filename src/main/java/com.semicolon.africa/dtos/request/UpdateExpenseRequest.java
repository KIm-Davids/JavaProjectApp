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
public class UpdateExpenseRequest {

    private String newDescription;
    private LocalDateTime newLocalDateTime;

    @Id
    private String month;
    private long newRent;
    private long newFoodExpense;
    private long newClothingExpenses;
    private long newTransportationFees;
    private long newTax;
    private long newMiscellaneous;
    private long newPersonalExpenses;
    private long newCustomExpensesAmount;
    private String newCustomExpense;
}
