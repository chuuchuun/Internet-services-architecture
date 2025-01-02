package com.example.UniversityService.repositories.university;

import com.example.UniversityService.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {
    List<University> findAll();
    List<University> findByNameIgnoreCase(String name);
    Optional<University> findById(UUID id);
}
