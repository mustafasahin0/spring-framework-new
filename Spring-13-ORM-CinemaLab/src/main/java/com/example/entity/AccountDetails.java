package com.example.entity;

import com.example.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account_details")
@Data
@NoArgsConstructor
public class AccountDetails extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private int age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    private UserAccount userAccount;

    public AccountDetails(String name, String address, String country, String city, String state, int age, String postalCode, Role role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
