package com.example.entity;

import com.example.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity // this class is an entity
@Table(name = "students") // if you want to change the name of the table in the db
public class Student {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName") // if you want to change the name of the column in the db
    private String lastName;
    private String email;

    @Transient // not saved in db
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate; // Add some comment?
    @Column(columnDefinition = "TIME") // TIME is a sql type, not a java type. so we need to specify the columnDefinition to tell the db what type it is.
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP") // TIMESTAMP is a sql type, not a java type. so we need to specify the columnDefinition to tell the db what type it is.
    private LocalTime birthDateTime;

    @Enumerated(EnumType.STRING) // tells the db to save the enum as a string
    private Gender gender;

}
