package com.example.UniversityService.controllers.university.mapper;

import com.example.UniversityService.controllers.university.dto.UniversityResponse;
import com.example.UniversityService.entity.University;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityToResponseMapper implements Function<University, UniversityResponse>{
    @Override
    public UniversityResponse apply(University university) {
        return UniversityResponse.builder()
                .id(university.getId())
                .name(university.getName())
                .location(university.getLocation())
                .build();
    }
}
