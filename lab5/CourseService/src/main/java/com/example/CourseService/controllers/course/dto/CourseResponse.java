package com.example.CourseService.controllers.course.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CourseResponse {
    UUID id;
    String name;
    int credits;
    UUID universityId;
}