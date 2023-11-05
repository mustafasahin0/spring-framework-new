package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "user_account")
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> ticketList;

    @OneToOne(mappedBy = "userAccount")
    private AccountDetails accountDetailsId;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
