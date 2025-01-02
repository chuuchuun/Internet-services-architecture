package com.example.UniversityService.controllers.university;

import com.example.UniversityService.controllers.university.dto.CreateUniversityRequest;
import com.example.UniversityService.controllers.university.dto.UniversitiesResponse;
import com.example.UniversityService.controllers.university.dto.UpdateUniversityRequest;
import com.example.UniversityService.controllers.university.dto.UniversityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
public interface UniversityController {
    @GetMapping("/universities")
    @ResponseStatus(HttpStatus.OK)
    UniversitiesResponse getUniversities();

    @GetMapping("/universities/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    UniversityResponse getUniversity(@PathVariable UUID uuid);

    @PutMapping("/universities") // PUT here, not POST because if does exist, updates it and all info about it
    @ResponseStatus(HttpStatus.CREATED)
    UniversityResponse createUniversity(@RequestBody CreateUniversityRequest request);

    @PatchMapping("/universities/{uuid}")    // PATCH here, not PUT because it demands that object exists (in content just new values, just a delta of the info stored here)
    @ResponseStatus(HttpStatus.OK)
    UniversityResponse updateUniversity(@PathVariable UUID uuid, @RequestBody UpdateUniversityRequest request);

    @DeleteMapping("/universities/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUniversity(@PathVariable UUID uuid);
}
