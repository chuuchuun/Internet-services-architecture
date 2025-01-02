package com.example.UniversityService.controllers.university.mapper;

import com.example.UniversityService.controllers.university.dto.CreateUniversityRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import com.example.UniversityService.entity.University;

@Component
public class CreateRequestToUniversityMapper implements Function<CreateUniversityRequest, University> {
    @Override
    public University apply(CreateUniversityRequest createUniversityRequest) {
        return University.builder()
                .name(createUniversityRequest.getName())
                .location(createUniversityRequest.getLocation())
                .build();
    }
}
