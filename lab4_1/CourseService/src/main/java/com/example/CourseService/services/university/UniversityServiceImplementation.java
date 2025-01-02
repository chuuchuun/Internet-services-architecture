package com.example.CourseService.services.university;

import com.example.CourseService.entities.University;
import com.example.CourseService.repositories.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@Service
public class UniversityServiceImplementation implements UniversityService {
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImplementation(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public Optional<University> findById(UUID id) {
        return universityRepository.findById(id);
    }

    @Override
    public void create(University university) {
        universityRepository.save(university);
    }

    @Override
    public void update(University university) {
        universityRepository.save(university);
    }

    @Override
    public void delete(UUID id) {
        universityRepository.deleteById(id);
    }


}
