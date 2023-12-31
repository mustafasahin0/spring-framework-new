package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Display all Departments in the furniture department
    List<Department> findByDepartment(String department);

    // Display all Departments in Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes "Hea" without duplicate
    List<Department> findDistinctTop3ByDivisionContains(String contains);

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String Division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);
}
