package com.example.CourseService.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "courses")
public class Course {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "course_id", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credits")
    private int credits;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}
