package com.example.controller;

import com.example.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @RequestMapping(value = "/register") // GET request
    @GetMapping("/register") // GET request
    public String register(Model model) {
        model.addAttribute("students", DataGenerator.createStudent());
        return "student/register";
    }

    @GetMapping("/welcome")
    public String info() {
        return "student/welcome";
    }
}
