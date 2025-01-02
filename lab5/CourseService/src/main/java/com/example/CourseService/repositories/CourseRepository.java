package com.example.CourseService.repositories;

import com.example.CourseService.entities.Course;
import com.example.CourseService.entities.University;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findAll();
    Optional<Course> findById(UUID id);
    List<Course> findByCredits(int credits);
    List<Course> findByUniversity(University university);
}
