package com.semicolon.africa.repository;

import com.semicolon.africa.dtos.request.ExpenseRequest;
import com.semicolon.africa.dtos.response.ExpenseResponse;
import com.semicolon.africa.values.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expenses, Expenses> {

    Expenses findByMonth(String month);
}
