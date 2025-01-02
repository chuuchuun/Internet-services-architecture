package com.example.CourseService.services.university;

import com.example.CourseService.entities.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityService {
    List<University> findAll();
    Optional<University> findById(UUID id);
    void create(University university);
    void update(University university);
    void delete(UUID id);
}
