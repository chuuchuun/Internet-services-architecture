package com.example.demo.controllers;

import com.example.demo.dtos.university.CreateUniversityDto;
import com.example.demo.dtos.university.ReadUniversityDto;
import com.example.demo.dtos.university.UpdateUniversityDto;
import com.example.demo.entities.University;
import com.example.demo.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/universities/")
    public ResponseEntity<List<ReadUniversityDto>> getUniversities() {
        var universities = universityService.findAll();

        return new ResponseEntity<>(universities.stream().map(ReadUniversityDto::from).toList(), HttpStatus.OK);
    }

    @GetMapping("/universities/{uuid}/")
    public ResponseEntity<ReadUniversityDto> getUniversity(@PathVariable UUID uuid) {
        var university = universityService.findById(uuid);

        return university.map(uni -> new ResponseEntity<>(ReadUniversityDto.from(uni), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/universities/")
    public ResponseEntity<ReadUniversityDto> createUniversity(@RequestBody CreateUniversityDto req) {
        var uni = University.builder()
                .name(req.getName())
                .location(req.getLocation())
                .build();

        universityService.create(uni);

        return new ResponseEntity<>(ReadUniversityDto.from(uni), HttpStatus.CREATED);
    }

    @PutMapping("/universities/{uuid}/")
    public ResponseEntity<ReadUniversityDto> updateUniversity(@PathVariable UUID uuid, @RequestBody UpdateUniversityDto req) {
        var result = universityService.findById(uuid);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var uni = result.get();
        uni.setName(req.getName());
        uni.setLocation(req.getLocation());
        universityService.update(uni);

        return new ResponseEntity<>(ReadUniversityDto.from(uni), HttpStatus.OK);
    }

    @DeleteMapping("/universities/{uuid}/")
    public ResponseEntity<Void> deleteUniversity(@PathVariable UUID uuid) {
        var uni = universityService.findById(uuid);

        if (uni.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        universityService.delete(uni.get().getUniversityId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}