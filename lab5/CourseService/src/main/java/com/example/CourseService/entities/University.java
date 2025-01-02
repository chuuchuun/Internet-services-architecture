package com.example.CourseService.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "universities")
public class University {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "university_id")
    private UUID id = UUID.randomUUID();


    @ToString.Exclude
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // propagate changes in course also to university; fetch courses lazily <=> only when needed
    private List<Course> courses = new ArrayList<>();

}
