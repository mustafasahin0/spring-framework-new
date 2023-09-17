package com.example.controller;

import com.example.enums.Gender;
import com.example.model.Mentor;
import net.datafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentor")
    public String mentor(Model model) {

        List<Mentor> mentorsList  = List.of(new Mentor(
                        "Mike", "Smith", 45, Gender.MALE),
                new Mentor("Tom", "Hanks", 65, Gender.MALE),
                new Mentor("Ammy", "Bryan", 25, Gender.FEMALE));

        model.addAttribute("mentors", mentorsList);

        return "/mentor/mentor-list";
    }
}
