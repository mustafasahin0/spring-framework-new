package com.example;

import com.example.config.ConfigApp;
import com.example.service.OvertimeSalaryService;
import com.example.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        SalaryService salaryService = context.getBean(SalaryService.class);
        OvertimeSalaryService overtimeSalaryService = context.getBean(OvertimeSalaryService.class);

        salaryService.calculateRegularSalary();
        overtimeSalaryService.calculateOvertimeSalary();
    }
}
