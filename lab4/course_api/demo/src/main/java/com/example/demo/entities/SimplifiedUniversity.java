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
@Table(name = "simplified_universities")
public class SimplifiedUniversity {
    @Id
    @Column(name = "university_id", nullable = false, unique = true)
    @Builder.Default
    private UUID universityId = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;
}
