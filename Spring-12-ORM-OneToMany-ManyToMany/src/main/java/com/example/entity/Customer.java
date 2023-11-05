package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Customer(String address, String email, String name, String surName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
    }
}
