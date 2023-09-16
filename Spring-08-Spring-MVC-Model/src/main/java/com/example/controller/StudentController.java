package com.example.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This tells Spring that this class is a controller
public class StudentController {

    @RequestMapping("/welcome") // This tells Spring to map this method to the URL
    public String homePage(Model model) {

        model.addAttribute("name", "Mustafa"); // This adds a key-value pair to the model object
        model.addAttribute("course", "Spring-MVC");

        return "/student/welcome";
    }
}
