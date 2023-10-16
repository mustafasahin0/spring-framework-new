package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class CreditAccount extends Account {

    BigDecimal creditLimit;
}
