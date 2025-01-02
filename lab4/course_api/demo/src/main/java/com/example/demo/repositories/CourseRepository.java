package com.example.demo.repositories;

import com.example.demo.entities.Course;
import com.example.demo.entities.SimplifiedUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findAll();
    Optional<Course> findById(UUID id);
    List<Course> findByCourseName(String courseName);
    List<Course> findByCredits(int credits);
    List<Course> findByUniversity(SimplifiedUniversity university);
    Course save(Course course);
}
