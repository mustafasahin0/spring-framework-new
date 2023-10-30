package com.example.bootstrap;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Region;
import com.example.enums.Gender;
import com.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20),154864, Gender.F);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26),56752, Gender.F);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17),95313, Gender.F);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014,03,02) ,119764,Gender.M);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), 55307,Gender.M);

        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");

        Region r1 = new Region("Southwest","United States");
        Region r2 = new Region("Central","United States");
        Region r3 = new Region("Northwest","United States");
        Region r4 = new Region("Quebec'","Canada");
        Region r5 = new Region("Central","Asia");




    }
}
