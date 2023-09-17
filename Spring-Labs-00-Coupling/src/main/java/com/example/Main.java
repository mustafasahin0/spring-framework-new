package com.example;
import com.example.loosely.BalanceManager;
import com.example.tightly.BalanceService;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        CustomerBalance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        GiftCardBalance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        // Tightly coupled
        BalanceService balanceService =
                new BalanceService(customerBalance, giftCardBalance);

        System.out.println(balanceService.checkoutFromCustomerBalance(new BigDecimal(80)));
        System.out.println(balanceService.checkoutFromGiftBalance(new BigDecimal(80)));

        // Loosely coupled

        BalanceManager balanceManager = new BalanceManager(user, BigDecimal.ZERO);
        System.out.println(balanceManager.checkout(new BigDecimal(80), customerBalance.getAmount()));
        System.out.println(balanceManager.checkout(new BigDecimal(180), giftCardBalance.getAmount()));
    }

}
