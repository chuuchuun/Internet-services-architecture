package com.example.demo.repositories;

import com.example.demo.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UniversityRepository extends JpaRepository<University, UUID> {
    List<University> findAll();
    List<University> findByName(String name);
    List<University> findByLocation(String location);
    Optional<University> findById(UUID id);
}
