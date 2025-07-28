package com.example.wimg.entity.repository;

import com.example.wimg.entity.enums.LoanStatus;
import lombok.Data;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("loans")
public class LoanEntity {
    @Id
    private String id;
    private double amount;
    private String clientId;
    private LocalDate date;
    private LoanStatus loanStatus;
    private int interestRate;
    private double finalPayment;
    private ClientEntity clientInfo;
}
