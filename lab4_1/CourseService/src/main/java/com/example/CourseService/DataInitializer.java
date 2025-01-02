package com.example.CourseService;

import com.example.CourseService.entities.Course;
import com.example.CourseService.entities.University;
import com.example.CourseService.services.course.CourseService;
import com.example.CourseService.services.university.UniversityService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer {
    private final CourseService cs;
    private final UniversityService us;
    private Random random = new Random(2137);

    @Autowired
    public DataInitializer(CourseService courseService, UniversityService universityService) {
        this.cs = courseService;
        this.us = universityService;
    }

    @PostConstruct
    public void createAndLoadData() {
        if(!cs.findAll().isEmpty() || !us.findAll().isEmpty()) {
            return; // something already exists, no need to initialize
        }

        List<University> universities = new ArrayList<>();
        List<String> universityNames = List.of("Politechnika Gdańska", "Uniwersytet Warszawski", "AGH");

        for(int i = 0; i < universityNames.size(); i++) {
            University university = University.builder()
                    .id(UUID.nameUUIDFromBytes(universityNames.get(i).getBytes()))
                    .build();
            universities.add(university);
            us.create(university);
        }

        List<String> characterNames = List.of("Art", "History", "Computer Science", "Physics");
        for(int i = 0; i < characterNames.size(); i++) {
            Course course = Course.builder()
                    .id(UUID.nameUUIDFromBytes(characterNames.get(i).getBytes()))
                    .name(characterNames.get(i))
                    .credits(random.nextInt(1, 12))
                    .university(universities.get(i % universityNames.size()))
                    .build();
            cs.create(course);
        }
    }
}
