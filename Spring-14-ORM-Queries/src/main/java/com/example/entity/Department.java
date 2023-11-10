package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private String department;
    private String division;
}
