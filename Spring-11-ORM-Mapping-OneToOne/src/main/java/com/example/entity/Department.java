package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity {

    private String department;
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
