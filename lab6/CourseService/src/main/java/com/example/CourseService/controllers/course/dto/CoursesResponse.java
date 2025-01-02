package com.example.CourseService.controllers.course.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CoursesResponse {
    List<Course> courses;

    @Value
    @Builder
    public static class Course {
        UUID id;
        String name;
    }
}