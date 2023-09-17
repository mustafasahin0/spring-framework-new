package com.example.account;

import com.example.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Saving {
    private Currency currency;
    private BigDecimal amount;
    private UUID accountId;

    public void initialize(){
        System.out.println("savings account " + "currency: "+ currency.getCode() + "amount: " + amount + "accountId" + accountId);
    }
}
