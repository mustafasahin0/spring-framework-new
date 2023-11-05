package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class Cart {
    private Map<Product, Integer> productMap;
    private BigDecimal cartTotalAmount;
}
