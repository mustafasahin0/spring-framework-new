package com.example.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class BalanceManager extends Balance {

    public BalanceManager(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    public boolean checkout(BigDecimal checkoutAmount, BigDecimal cardBalanceAmount) {
        return cardBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
