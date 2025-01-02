package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class CourseServiceImplementation implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    };

    @Override
    public Optional<Course> findById(UUID id){
        return courseRepository.findById(id);
    };
    @Override
    public List<Course> findByCourseName(String courseName){
        return courseRepository.findByCourseName(courseName);
    };

    @Override
    public List<Course> findByCredits(int credits){
        return courseRepository.findByCredits(credits);
    };
    @Override
    public List<Course> findByUniversity(University university){
        return courseRepository.findByUniversity(university);
    };

    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(UUID courseID) {
        courseRepository.deleteById(courseID);
    }
}