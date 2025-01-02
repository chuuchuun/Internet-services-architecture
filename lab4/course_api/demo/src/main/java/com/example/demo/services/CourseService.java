package com.example.demo.services;

import com.example.demo.dtos.course.CreateCourseDto;
import com.example.demo.dtos.course.ReadCourseDto;
import com.example.demo.entities.Course;
import com.example.demo.entities.SimplifiedUniversity;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CourseService {

    List<Course> findAll();
    Optional<Course> findById(UUID id);
    List<Course> findByCourseName(String courseName);
    List<Course> findByCredits(int credits);
    List<Course> findByUniversity(SimplifiedUniversity university);
    void create(Course course);
    void update(Course course);
    void delete(UUID courseId);
}
