package com.example.CourseService.controllers.course.mapper;

import com.example.CourseService.entities.Course;
import com.example.CourseService.controllers.course.dto.CoursesResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CoursesToResponseMapper implements Function<List<Course>, CoursesResponse> {

    public CoursesResponse apply(List<Course> courses) {
        return CoursesResponse.builder()
                .courses(courses.stream()
                        .map(character ->
                            CoursesResponse.Course.builder()
                                    .id(character.getId())
                                    .name(character.getName())
                                    .build())
                        .toList()
                ).build();
    }
}
