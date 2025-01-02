package com.example.demo.dtos.university;


import com.example.demo.entities.University;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ReadUniversityDto {
    UUID id;
    String name;
    String location;
    List<CourseInUniversityResponse> courses;

    @Value
    public static class CourseInUniversityResponse {
        UUID courseId;
        String courseName;
    }

    public static ReadUniversityDto from(University university) {
        return new ReadUniversityDto(
                university.getUniversityId(),
                university.getName(),
                university.getLocation(),
                university.getCourses() != null ? university.getCourses().stream()
                        .map(course -> new CourseInUniversityResponse(
                                course.getCourseId(),
                                course.getCourseName()))
                        .collect(Collectors.toList()) : new ArrayList<>()
        );
    }

}
