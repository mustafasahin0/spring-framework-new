package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car") // This tells Spring to map this method to the URL
public class CarController {

    @RequestMapping("/info") // This tells Spring to map this method to the URL: localhost:8080/car/info?make=BMW
    public String carInfo(@RequestParam String make, @RequestParam Integer year, Model model) {

        model.addAttribute("make", make); // This adds a key-value pair to the model object
        model.addAttribute("year", year); // This adds a key-value pair to the model object

        return "car/car-info";
    }


    @RequestMapping("/info2") // This tells Spring to map this method to the URL: localhost:8080/car/info?make=BMW
    public String carInfo2(@RequestParam(value = "make2", required = false, defaultValue = "Tesla") String make, @RequestParam Integer year, Model model) {

        model.addAttribute("make2", make); // This adds a key-value pair to the model object
        model.addAttribute("year", year); // This adds a key-value pair to the model object

        return "car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year, Model model) {
        model.addAttribute("make", make); // This adds a key-value pair to the model object
        model.addAttribute("year", year); // This adds a key-value pair to the model object
        return "car/car-info";
    }
}
