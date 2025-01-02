package com.example.demo.dtos.course;

import lombok.Value;

@Value
public class UpdateCourseDto {
    String courseName;
    int credits;
}