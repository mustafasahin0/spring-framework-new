package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotations that are used to mark a specific class as a controller
public class HomeController {

    @RequestMapping("/home") // Annotations that are used to mark a specific method as a request handler
    public String home() {
        return "home.html"; // This is the name of the html file that will be returned
    }

    @RequestMapping("/welcome")
    public String home2() {
        return "welcome.html";
    }

    @RequestMapping
    public String  home3() {
        return "welcome.html";
    }

}
