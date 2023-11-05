package com.example.bootstrap;

import com.example.entity.Student;
import net.datafaker.Faker;

import java.util.List;

public class DataGenerator {

    public static List<Student> createStudent() {
        Faker faker = new Faker();
        List<Student> students = List.of(
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().state()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().state()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().state()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().state()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().state())
        );
        return students;
    }
}
