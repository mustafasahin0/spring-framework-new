package com.example.repository;

import com.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {

    // Assume we are getting this data from a database
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch", "IT", 65);

        return employee.getHourlyRate();
    }
}
