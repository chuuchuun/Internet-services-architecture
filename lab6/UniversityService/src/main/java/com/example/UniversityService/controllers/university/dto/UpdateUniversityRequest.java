package com.example.UniversityService.controllers.university.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateUniversityRequest {
    String name;
    String location;
}
