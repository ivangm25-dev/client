package com.example.wimg.entity.repository;

import com.example.wimg.entity.enums.CustomerType;
import lombok.Data;

@Data
public class ClientEntity {
    private String id;
    private String name;
    private String email;
    private int age;
    private CustomerType customerType;
    private boolean discount;
}
