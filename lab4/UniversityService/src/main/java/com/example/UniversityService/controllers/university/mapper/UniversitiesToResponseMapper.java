package com.example.UniversityService.controllers.university.mapper;

import com.example.UniversityService.controllers.university.dto.UniversitiesResponse;
import com.example.UniversityService.entity.University;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class UniversitiesToResponseMapper implements Function<List<University>, UniversitiesResponse>{
    @Override
    public UniversitiesResponse apply(List<University> universities) {
        return UniversitiesResponse.builder()
                .universities(universities.stream()
                        .map(university -> UniversitiesResponse.University.builder()
                                .id(university.getId())
                                .name(university.getName())
                                .build())
                        .toList())
                .build();
    }
}
