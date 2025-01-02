package com.example.UniversityService;

import com.example.UniversityService.entity.University;
import com.example.UniversityService.repositories.university.UniversityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer {
    private final UniversityRepository ur;
    private Random random = new Random(2137);

    @Autowired
    public DataInitializer(UniversityRepository universityRepository) {
        this.ur = universityRepository;
    }

    @PostConstruct
    public void createAndLoadData() {
        if(!ur.findAll().isEmpty()) {
            return; // something already exists, no need to initialize
        }

        List<University> universities = new ArrayList<>();
        List<String> universityNames = List.of("Politechnika Gdańska", "Uniwersytet Warszawski", "AGH");
        List<String> universityLocations = List.of("Gdańsk", "Warszawa", "Kraków");
        for(int i = 0; i < universityNames.size(); i++) {
            University university = University.builder()
                    .id(UUID.nameUUIDFromBytes(universityNames.get(i).getBytes()))
                    .name(universityNames.get(i))
                    .location(universityLocations.get(i))
                    .build();
            universities.add(university);
        }
        ur.saveAll(universities);

    }
}
