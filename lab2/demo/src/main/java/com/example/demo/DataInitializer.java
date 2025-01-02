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

    private final UniversityService universityService;
    private final CourseService courseService;

    @Autowired
    public DataInitializer(UniversityService universityService, CourseService courseService) {
        this.universityService = universityService;
        this.courseService = courseService;
    }

    @PostConstruct
    public void init() {
        if (!universityService.findAll().isEmpty() || !universityService.findAll().isEmpty()) {
            return;
        }

        List<University> universities = new ArrayList<>();
        List<String> universitiesNames = List.of("Politechnika Gdanska", "Uniwersytet Warszawski", "AGH");
        List<String> locations = List.of("Gdansk", "Warszawa", "Krakow");
        for (int i = 0; i < universitiesNames.size(); i++) {
            University university = University.builder()
                    .name(universitiesNames.get(i))
                    .location(locations.get(i))
                    .build();
            universities.add(university);
            universityService.create(university);
        }

        List<String> coursesNames = List.of("Art", "History", "Physics");
        List<Integer> coursesCredits = List.of(3, 4, 6);
        for (int i = 0; i < coursesNames.size(); i++) {

            Course course = Course.builder()
                    .courseName(coursesNames.get(i))
                    .credits(coursesCredits.get(i))
                    .university(universities.get(i % universitiesNames.size()))
                    .build();
            courseService.create(course);
        }
    }
}
