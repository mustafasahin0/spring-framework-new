package org.example.service;


import org.example.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO getCourseById(long courseId);

    List<CourseDTO> getCoursesByCategory(String category);

    List<CourseDTO> getCourses();

    void updateCourse(Long courseId, CourseDTO courseDTO);

    void deleteCourseById(Long courseId);

    void deleteCourses();

}
