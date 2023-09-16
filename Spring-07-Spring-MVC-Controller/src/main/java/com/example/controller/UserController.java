package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotations that are used to mark a specific class as a controller
public class UserController {

    @RequestMapping("/user")
    public String user() {
        return "user/userinfo.html"; // This is the name of the html file that will be returned
    }
}
