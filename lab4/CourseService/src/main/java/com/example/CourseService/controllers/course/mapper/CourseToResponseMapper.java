package com.example.CourseService.controllers.course.mapper;

import com.example.CourseService.controllers.course.dto.CourseResponse;
import com.example.CourseService.entities.Course;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class CourseToResponseMapper implements Function<Course, CourseResponse> {
    @Override
    public CourseResponse apply(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .credits(course.getCredits())
                .universityId(course.getUniversity().getId())
                .build();
    }
}
