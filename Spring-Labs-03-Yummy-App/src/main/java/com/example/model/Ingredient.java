package com.example.model;

import com.example.enums.QuantityType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    private String name;
    private int quantity;
    private QuantityType quantityType;
}
