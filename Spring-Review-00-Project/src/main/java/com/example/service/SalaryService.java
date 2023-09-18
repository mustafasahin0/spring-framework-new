package com.example.service;

import org.springframework.stereotype.Component;
import com.example.repository.EmployeeRepository;
import com.example.repository.HoursRepository;

@Component
public class SalaryService {

    HoursRepository hoursRepository;
    EmployeeRepository employeeRepository;

    public SalaryService(HoursRepository hoursRepository, EmployeeRepository employeeRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateRegularSalary() {
        // Hourly rate * hours worked
        int salary = employeeRepository.getHourlyRate() * hoursRepository.getHours();
        System.out.println("Regular salary: " + salary);
    }
}
