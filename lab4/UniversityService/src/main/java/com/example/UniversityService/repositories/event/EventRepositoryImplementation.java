package com.example.UniversityService.repositories.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class EventRepositoryImplementation implements EventRepository {

    @Qualifier("course-service")
    private final RestTemplate courseServiceRestTemplate;

    @Autowired
    public EventRepositoryImplementation(RestTemplate courseServiceRestTemplate) {
        this.courseServiceRestTemplate = courseServiceRestTemplate;
    }

    @Override
    public void sendCreateUniversityEvent(UUID universityId) {
        courseServiceRestTemplate.put("/universities/" + universityId, null);
    }

    @Override
    public void sendDeleteUniversityEvent(UUID universityId) {
        courseServiceRestTemplate.delete("/universities/" + universityId);
    }
}
