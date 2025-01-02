package com.example.UniversityService.service.university;

import com.example.UniversityService.entity.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityService {
    List<University> findAll();
    List<University> findByNameIgnoreCase(String name);
    Optional<University> findById(UUID id);
    void create(University university);
    void update(University university);
    void delete(UUID id);
}
