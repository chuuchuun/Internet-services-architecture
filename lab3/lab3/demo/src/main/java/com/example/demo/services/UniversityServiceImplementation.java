package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UniversityServiceImplementation implements UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImplementation(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<University> findAll(){
        return universityRepository.findAll();
    };
    @Override
    public Optional<University> findById(UUID id){
        return universityRepository.findById(id);
    };
    @Override
    public List<University> findByName(String name){
        return universityRepository.findByName(name);
    };

    @Override
    public List<University> findByLocation(String location){
        return universityRepository.findByLocation(location);
    };
    @Override
    public void create(University university){
        universityRepository.save(university);
    };

    @Override
    public void update(University university){
        universityRepository.save(university);
    };

    @Override
    public void delete(UUID id){
        universityRepository.deleteById(id);
    };
}
