package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseEventPublisher {

    private final RestTemplate restTemplate;

    public CourseEventPublisher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void publishCourseEvent(CourseEventDto event) {
        String url = "http://localhost:8080/api/events/courses"; // URL of the University Management app
        restTemplate.postForEntity(url, event, Void.class);
    }
}
