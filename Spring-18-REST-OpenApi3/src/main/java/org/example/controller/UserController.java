package org.example.controller;



import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User CRUD Operations")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

}