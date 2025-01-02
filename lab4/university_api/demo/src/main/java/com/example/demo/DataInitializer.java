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

    @Autowired
    public DataInitializer(UniversityService universityService) {
        this.universityService = universityService;
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
    }
}
