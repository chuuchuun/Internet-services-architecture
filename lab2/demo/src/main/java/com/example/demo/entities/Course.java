package com.example.demo.entities;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
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

    @Setter
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Setter
    @Column(name = "credits")
    private int credits;

    @Setter
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    public UUID getCourseId() {
        return courseId;
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }


    public University getUniversity() {
        return university;
    }


    public static CourseBuilder inMemoryBuilder(){
        return new inMemoryBuilder();
    }
    public static class inMemoryBuilder extends CourseBuilder{
        @Override
        public Course build() {
            if(super.university == null){
                throw new IllegalStateException("university is null");
            }
            var course = super.build();
            super.university.getCourses().add(course);
            return course;
        }

    }
}
