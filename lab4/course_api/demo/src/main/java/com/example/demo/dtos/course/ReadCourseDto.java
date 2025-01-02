package com.example.demo.dtos.course;


import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import lombok.Value;

import java.util.UUID;

@Value
public class ReadCourseDto {
    UUID courseId;
    String courseName;
    int credits;
    UniversityInCourseResponse university;

    @Value
    public static class UniversityInCourseResponse {
        UUID id;
        String name;
    }

    public static ReadCourseDto from(Course course) {
        University university = course.getUniversity();
        return new ReadCourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getCredits(),
                new UniversityInCourseResponse(
                        university.getUniversityId(),
                        university.getName()
                )
        );
    }
}