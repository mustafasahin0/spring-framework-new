package com.example.controller;

import com.example.model.Student;
import net.datafaker.Faker;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller // This tells Spring that this class is a controller
public class StudentController {

    @RequestMapping("/welcome") // This tells Spring to map this method to the URL
    public String homePage(Model model) {

        model.addAttribute("name", "Mustafa"); // This adds a key-value pair to the model object
        model.addAttribute("course", "Spring-MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        // create some random studentId(0-1000) and show it in the UI
        int studentId = new Random().nextInt(1000);
        model.addAttribute("studentId", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        model.addAttribute("numbers", numbers);

        Faker faker =  new Faker();
        Student student = new Student(faker.idNumber().hashCode(), faker.name().firstName(), faker.name().lastName());
        model.addAttribute("student", student);

        return "/student/welcome";
    }
}
