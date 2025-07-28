package com.example.wimg.entity.dto;

import com.example.wimg.entity.enums.CustomerType;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record RequestClientDTO(@NotBlank
                               @NotNull
                               @NotEmpty
                               String id,
                               @NotEmpty
                               @JsonAlias("nombre")
                               String name,
                               @Email
                               String email,
                               @NotNull
                               @JsonAlias("edad")
                               int age,
                               @NotNull
                               @JsonAlias("tipoCliente")
                               CustomerType customerType) {
}
