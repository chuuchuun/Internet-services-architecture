package com.example.UniversityService.controllers.university;

import com.example.UniversityService.controllers.university.dto.CreateUniversityRequest;
import com.example.UniversityService.controllers.university.dto.UniversityResponse;
import com.example.UniversityService.controllers.university.dto.UniversitiesResponse;
import com.example.UniversityService.controllers.university.dto.UpdateUniversityRequest;
import com.example.UniversityService.controllers.university.mapper.CreateRequestToUniversityMapper;
import com.example.UniversityService.controllers.university.mapper.UniversitiesToResponseMapper;
import com.example.UniversityService.controllers.university.mapper.UniversityToResponseMapper;
import com.example.UniversityService.service.university.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class UniversityControllerImplementation implements UniversityController {

    private final UniversityService universityService;

    private final UniversityToResponseMapper universityToResponseMapper;
    private final UniversitiesToResponseMapper universitiesToResponseMapper;
    private final CreateRequestToUniversityMapper createRequestToUniversityMapper;

    public UniversityControllerImplementation(UniversityService universityService,
                                              UniversityToResponseMapper universityToResponseMapper,
                                              UniversitiesToResponseMapper universitiesToResponseMapper,
                                              CreateRequestToUniversityMapper createRequestToUniversityMapper) {

        this.universityService = universityService;
        this.universityToResponseMapper = universityToResponseMapper;
        this.universitiesToResponseMapper = universitiesToResponseMapper;
        this.createRequestToUniversityMapper = createRequestToUniversityMapper;
    }

    @Override
    public UniversitiesResponse getUniversities() {
        return universitiesToResponseMapper.apply(universityService.findAll());
    }

    @Override
    public UniversityResponse getUniversity(UUID uuid) {
        return universityService.findById(uuid)
                .map(universityToResponseMapper)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));
    }

    @Override
    public UniversityResponse createUniversity(CreateUniversityRequest request) {
        var university = createRequestToUniversityMapper.apply(request);
        universityService.create(university);

        return universityToResponseMapper.apply(university);
    }

    @Override
    public UniversityResponse updateUniversity(UUID uuid, UpdateUniversityRequest request) {
        var university = universityService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));

        university.setName(request.getName());
        university.setLocation(request.getLocation());

        universityService.update(university);

        return universityToResponseMapper.apply(university);
    }

    @Override
    public void deleteUniversity(UUID uuid) {
        if(universityService.findById(uuid).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found");
        }
        universityService.delete(uuid);
    }
}
