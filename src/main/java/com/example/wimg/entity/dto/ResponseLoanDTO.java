package com.example.wimg.entity.dto;

import com.example.wimg.entity.enums.LoanStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public record ResponseLoanDTO(String id,
                              @JsonProperty("monto")
                              @JsonAlias("amount")
                              double amount,
                              @JsonProperty("clienteId")
                              @JsonAlias("clientId")
                              String clientId,
                              @JsonProperty("fecha")
                              @JsonAlias("date")
                              LocalDate date,
                              @JsonProperty("estado")
                              @JsonAlias("loanStatus")
                              LoanStatus loanStatus,
                              @JsonProperty("pagoFinal")
                              @JsonAlias("finalPayment")
                              double finalPayment,
                              @JsonProperty("tasaInteres")
                              @JsonAlias("interestRate")
                              int interestRate) {

}
