package com.example.service;

import com.example.repository.EmployeeRepository;
import com.example.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public OvertimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("OTH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateOvertimeSalary() {
        int overTimeSalary = employeeRepository.getHourlyRate() * hoursRepository.getHours();
        System.out.println("Overtime salary: " + overTimeSalary);
    }
}
