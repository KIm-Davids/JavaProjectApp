package com.semicolon.africa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface profitRepository extends MongoRepository<profitRepository, Long> {
}
