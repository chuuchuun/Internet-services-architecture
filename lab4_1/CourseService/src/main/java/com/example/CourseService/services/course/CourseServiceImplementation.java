package com.example.CourseService.services.course;

import com.example.CourseService.entities.Course;
import com.example.CourseService.repositories.CourseRepository;
import com.example.CourseService.entities.University;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional // When using database
@Service
public class CourseServiceImplementation implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired // Dependency injection
    // dependency injection - in this class I want to use instance of another class.
    // I can pass it as a parameter in constructor or
    // using a setter or
    // using @Autowired annotation - when building, it will detect new object is needed and will create it.
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(UUID id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findByUniversity(University university) {
        return courseRepository.findByUniversity(university);
    }

    @Override
    public List<Course> findByCredits(int credits) {
        return courseRepository.findByCredits(credits);
    }

    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(UUID characterId) {
        courseRepository.deleteById(characterId);
    }

}
