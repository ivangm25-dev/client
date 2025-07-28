package com.example.wimg.entity.dto;

import com.example.wimg.entity.enums.CustomerType;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseClientDTO(String id,
                                @JsonProperty("nombre")
                                @JsonAlias("name")
                                String name,
                                String email,
                                @JsonProperty("edad")
                                @JsonAlias("age")
                                int age,
                                @JsonProperty("tipoCliente")
                                @JsonAlias("customerType")
                                CustomerType customerType,
                                @JsonProperty("descuento")
                                @JsonAlias("discount")
                                boolean discount) {

}