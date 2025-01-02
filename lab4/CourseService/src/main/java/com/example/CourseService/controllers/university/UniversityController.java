package com.example.CourseService.controllers.university;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
public interface UniversityController {

    @PutMapping("/universities/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    void createUniversity(@PathVariable UUID uuid);

    @DeleteMapping("/universities/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUniversity(@PathVariable UUID uuid);
}
