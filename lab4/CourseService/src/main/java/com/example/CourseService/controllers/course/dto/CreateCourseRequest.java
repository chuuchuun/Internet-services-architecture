package com.example.CourseService.controllers.course.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateCourseRequest {
    String name;
    int credits;
}