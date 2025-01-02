package com.example.UniversityService.controllers.university.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UniversityResponse {
    UUID id;
    String name;
    String location;
}
