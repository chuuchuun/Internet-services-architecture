package com.example.demo;

import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import com.example.demo.services.CourseService;
import com.example.demo.services.UniversityService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer {

    private final CourseService courseService;

    @Autowired
    public DataInitializer(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostConstruct
    public void init() {


        List<String> coursesNames = List.of("Art", "History", "Physics");
        List<Integer> coursesCredits = List.of(3, 4, 6);
        for (int i = 0; i < coursesNames.size(); i++) {

            Course course = Course.builder()
                    .courseName(coursesNames.get(i))
                    .credits(coursesCredits.get(i))
                    .build();
            courseService.create(course);
        }
    }
}
