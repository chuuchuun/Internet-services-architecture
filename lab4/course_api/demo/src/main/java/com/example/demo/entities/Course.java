package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id", nullable = false, unique = true)
    @Builder.Default
    private UUID courseId = UUID.randomUUID();

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "credits")
    private int credits;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private SimplifiedUniversity university;
}
