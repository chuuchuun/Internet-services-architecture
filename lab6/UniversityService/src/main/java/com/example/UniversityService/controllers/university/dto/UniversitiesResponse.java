package com.example.UniversityService.controllers.university.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class UniversitiesResponse {
    List<University> universities;

    @Value
    @Builder
    public static class University {
        UUID id;
        String name;
    }
}