package com.example.CourseService.repositories;

import com.example.CourseService.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {
    List<University> findAll();
    Optional<University> findById(UUID id);
}
