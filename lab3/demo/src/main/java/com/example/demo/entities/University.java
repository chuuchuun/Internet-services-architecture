package com.example.demo.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "universities")
public class University {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Column(name = "location")
    private String location;

    @Getter
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();


    // Getters and Setters
    public UUID getUniversityId() {
        return id;
    }

    public void addCourse(Course course) {
        course.setUniversity(this);
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
