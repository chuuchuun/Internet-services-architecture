package com.example.UniversityService.service.university;

import com.example.UniversityService.entity.University;
import com.example.UniversityService.repositories.event.EventRepository;
import com.example.UniversityService.repositories.university.UniversityRepository;
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
    private final EventRepository eventRepository;

    @Autowired
    public UniversityServiceImplementation(UniversityRepository universityRepository, EventRepository eventRepository) {
        this.universityRepository = universityRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public List<University> findByNameIgnoreCase(String name) {
        return universityRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Optional<University> findById(UUID id) {
        return universityRepository.findById(id);
    }

    @Override
    public void create(University university) {
        universityRepository.save(university);
        eventRepository.sendCreateUniversityEvent(university.getId());
    }

    @Override
    public void update(University university) {
        universityRepository.save(university);
    }

    @Override
    public void delete(UUID id) {
        universityRepository.deleteById(id);
        eventRepository.sendDeleteUniversityEvent(id);
    }


}
