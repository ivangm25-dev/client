package com.example.wimg.repository;

import com.example.wimg.entity.repository.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<LoanEntity, String> {

}