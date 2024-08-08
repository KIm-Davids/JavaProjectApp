package com.semicolon.africa.repository;

import com.semicolon.africa.models.Income;
import com.semicolon.africa.values.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, Income> {
    Income findByMonth(String month);
}
