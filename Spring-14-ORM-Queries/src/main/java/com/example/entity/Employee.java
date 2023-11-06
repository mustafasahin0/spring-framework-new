package com.example.entity;

import com.example.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table
@Entity(name = "employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    private String department;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;
}
