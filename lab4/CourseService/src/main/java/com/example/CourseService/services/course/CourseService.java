package com.example.CourseService.services.course;

import com.example.CourseService.entities.Course;
import com.example.CourseService.entities.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findById(UUID id);
    List<Course> findByUniversity(University university);
    List<Course> findByCredits(int credits);


    void create(Course course);
    void update(Course course);
    void delete(UUID characterId);
}
