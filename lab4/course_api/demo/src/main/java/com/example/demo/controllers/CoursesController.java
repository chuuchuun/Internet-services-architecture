package com.example.demo.controllers;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CourseRepository courseRepository;

    public CoursesController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable UUID id, @RequestBody Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setCredits(updatedCourse.getCredits());
                    course.setUniversity(updatedCourse.getUniversity());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable UUID id) {
        courseRepository.deleteById(id);
    }
}

@RestController
@RequestMapping("/universities")
public class SimplifiedUniversityController {
    private final SimplifiedUniversityRepository repository;

    public SimplifiedUniversityController(SimplifiedUniversityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SimplifiedUniversity> getAllUniversities() {
        return repository.findAll();
    }

    @PostMapping
    public SimplifiedUniversity createUniversity(@RequestBody SimplifiedUniversity university) {
        return repository.save(university);
    }
}
