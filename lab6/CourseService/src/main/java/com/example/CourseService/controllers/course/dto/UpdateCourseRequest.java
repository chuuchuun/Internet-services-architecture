package com.example.CourseService.controllers.course.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateCourseRequest {
    String name;
    Integer credits;
}