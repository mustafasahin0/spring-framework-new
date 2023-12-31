package com.example.bootstrap;

import com.example.entity.Department;
import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------- REGION START ----------------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findAllByCountryContains: " + regionRepository.findAllByCountryContains("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-------------------- REGION END ------------------------");

        System.out.println("-------------------- DEPARTMENT START ----------------------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findByDivisionIs: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("-------------------- DEPARTMENT END ----------------------");

        System.out.println("-------------------- EMPLOYEE START ----------------------");

        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());

        System.out.println("-------------------- EMPLOYEE END ----------------------");

        System.out.println("-------------------- COURSE START ----------------------");

        System.out.println("-------------------------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("existsByName: " + courseRepository.existsByName("JavaScript for All"));
        System.out.println("countByCategory: " + courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);
        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("-------------------- COURSE END ----------------------");
    }
}
