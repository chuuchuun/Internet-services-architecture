package com.example.CourseService.controllers.course.mapper;


import com.example.CourseService.entities.Course;
import org.springframework.stereotype.Component;
import java.util.function.Function;

import com.example.CourseService.controllers.course.dto.CreateCourseRequest;

@Component
public class CreateRequestToCourseMapper implements Function<CreateCourseRequest, Course> {
    @Override
    public Course apply(CreateCourseRequest createCourseRequest) {
        return Course.builder()
                .name(createCourseRequest.getName())
                .credits(createCourseRequest.getCredits())
                .build();
    }
}