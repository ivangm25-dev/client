package com.example.wimg.entity.dto;

import com.example.wimg.entity.enums.LoanStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public record RequestLoanDTO(@NotBlank
                             @NotNull
                             @NotEmpty
                             String id,
                             @NotNull
                             @JsonAlias("monto")
                             double amount,
                             @NotBlank
                             @NotNull
                             @NotEmpty
                             @JsonAlias("clienteId")
                             String clientId,
                             @NotNull
                             @JsonAlias("fecha")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                             @JsonFormat(pattern = "yyyy-MM-dd")
                             LocalDate date,
                             @NotNull
                             @JsonAlias("estado")
                             LoanStatus loanStatus) {
}
