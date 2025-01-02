package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import com.example.demo.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityService {

    List<University> findAll();
    Optional<University> findById(UUID id);
    List<University> findByName(String name);
    List<University> findByLocation(String location);
    void create(University university);
    void update(University university);
    void delete(UUID id);
}