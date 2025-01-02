package com.example.CourseService.controllers.university;

import com.example.CourseService.entities.University;
import com.example.CourseService.services.university.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class UniversityControllerImplementation implements UniversityController {

    private final UniversityService universityService;


    public UniversityControllerImplementation(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Override
    public void createUniversity(UUID uuid) {
        if(uuid == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UUID nie może być puste!");
        }

        if(universityService.findById(uuid).isPresent())
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Profesja już istnieje!");
        }

        universityService.create(University.builder().id(uuid).build());
    }

    @Override
    public void deleteUniversity(UUID uuid) {
        if(universityService.findById(uuid).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje!");
        }

        universityService.delete(uuid);
    }
}
