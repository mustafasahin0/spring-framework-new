package org.example.controller;

import org.example.entity.Account;
import org.example.entity.User;
import org.example.repository.AccountRepository;
import org.example.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts() {
        return accountRepository.findAll();
    }
}
