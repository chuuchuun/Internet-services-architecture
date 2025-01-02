package com.example.CourseService.controllers.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.CourseService.controllers.course.dto.*;



import java.util.UUID;
public interface CourseController {
    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    CoursesResponse getCourses();

    @GetMapping("/courses/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CourseResponse getCourse(@PathVariable UUID uuid);

    @GetMapping("/universities/{uuid}/courses")
    @ResponseStatus(HttpStatus.OK)
    CoursesResponse getCoursesByUniversity(@PathVariable UUID uuid);

    @PostMapping("/universities/{uuid}/courses") // POST here, because we only need to create a new object
    @ResponseStatus(HttpStatus.CREATED)
    CourseResponse createCourse(@PathVariable UUID uuid, @RequestBody CreateCourseRequest request);

    @PatchMapping("/courses/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CourseResponse updateCourse(@PathVariable UUID uuid, @RequestBody UpdateCourseRequest request);

    @DeleteMapping("/courses/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCourse(@PathVariable UUID uuid);
}