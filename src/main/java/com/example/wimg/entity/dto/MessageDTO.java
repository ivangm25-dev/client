package com.example.wimg.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageDTO(@JsonProperty("mensaje")
                         @JsonAlias("message")
                         String message) {
}
