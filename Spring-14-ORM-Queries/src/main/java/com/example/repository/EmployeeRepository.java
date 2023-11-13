package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Display all employees with email address
    List<Employee> findByEmail(String email);

    // Displat All Employees with first name ' ' and last name ' ' and show all emlpoyees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employees that first name is not ' '
    List<Employee> findAllByFirstNameIsNot(String firstName);

    // Display all employees where last name start with
    List<Employee> findByLastNameStartsWith(String pattern);

    // Display all employees with salaries higher than " "
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less than equal " "
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries greater and equal to '' in order
    List<Employee>  findEmployeeBySalaryIsGreaterThanEqualOOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

 }
