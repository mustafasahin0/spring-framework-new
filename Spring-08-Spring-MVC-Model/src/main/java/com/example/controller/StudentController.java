package com.example.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration // This tells Spring that this is a configuration class
public class StudentController {

    @RequestMapping("/welcome") // This tells Spring to map this method to the URL
    public String homePage() {
        return "/student/welcome";
    }
}
