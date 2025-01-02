package com.example.demo.dtos.course;
import lombok.Value;

@Value
public class CreateCourseDto {
    String courseName;
    int credits;
}