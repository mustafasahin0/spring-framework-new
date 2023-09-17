package com.example.loosely;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public abstract class Balance {

    private UUID userId;
    private BigDecimal amount;

    public Balance(UUID userId, BigDecimal amount) {
    }
}
