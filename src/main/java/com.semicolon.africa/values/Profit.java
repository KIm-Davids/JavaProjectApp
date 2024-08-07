package com.semicolon.africa.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profit {

    private long netProfit;
    private long grossProfit;
    //Here we do the expenses - income calculation
}
