package com.example.demo.controllers;

import com.example.demo.entities.Course;
import com.example.demo.dtos.course.CreateCourseDto;
import com.example.demo.dtos.course.ReadCourseDto;
import com.example.demo.dtos.course.UpdateCourseDto;
import com.example.demo.services.CourseService;
import com.example.demo.services.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CoursesController {

    private final CourseService courseService;
    private final UniversityService universityService;

    public CoursesController(CourseService courseService, UniversityService universityService) {
        this.courseService = courseService;
        this.universityService = universityService;
    }

    @GetMapping("/courses/")
    public ResponseEntity<List<ReadCourseDto>> getCourses() {
        return new ResponseEntity<>(courseService.findAll().stream().map(ReadCourseDto::from).toList(), HttpStatus.OK);
    }

    @GetMapping("/courses/{uuid}/")
    public ResponseEntity<ReadCourseDto> getCourse(@PathVariable UUID uuid) {
        var course = courseService.findById(uuid);
        return course.map(value -> new ResponseEntity<>(ReadCourseDto.from(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/universities/{uuid}/courses/")
    public ResponseEntity<List<ReadCourseDto>> getCoursesFromUniversity(@PathVariable UUID uuid) {
        var university = universityService.findById(uuid);

        return university.map(u -> new ResponseEntity<>(u.getCourses().stream().map(ReadCourseDto::from).toList(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/universities/{uuid}/courses/")
    public ResponseEntity<ReadCourseDto> createCourse(@PathVariable UUID uuid, @RequestBody CreateCourseDto req) {
        var university = universityService.findById(uuid);

        if (university.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var newCourse = Course.builder()
                .courseName(req.getCourseName())
                .credits(req.getCredits())
                .university(university.get())
                .build();

        courseService.create(newCourse);
        return new ResponseEntity<>(ReadCourseDto.from(newCourse), HttpStatus.CREATED);
    }

    @PutMapping("/courses/{uuid}/")
    public ResponseEntity<ReadCourseDto> updateCourse(@PathVariable UUID uuid, @RequestBody UpdateCourseDto req) {
        var result = courseService.findById(uuid);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var course = result.get();
        course.setCourseName(req.getCourseName());
        course.setCredits(req.getCredits());
        courseService.update(course);

        return new ResponseEntity<>(ReadCourseDto.from(course), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{uuid}/")
    public ResponseEntity<Void> deleteCourse(@PathVariable UUID uuid) {
        var course = courseService.findById(uuid);

        if (course.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        courseService.delete(course.get().getCourseId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
