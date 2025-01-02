package com.example.UniversityService.repositories.event;

import java.util.UUID;

public interface EventRepository {
    void sendCreateUniversityEvent(UUID categoryId);

    void sendDeleteUniversityEvent(UUID categoryId);
}
