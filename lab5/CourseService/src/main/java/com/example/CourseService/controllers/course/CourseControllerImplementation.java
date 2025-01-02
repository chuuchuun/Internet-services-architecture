package com.example.CourseService.controllers.course;

import com.example.CourseService.controllers.course.mapper.CourseToResponseMapper;
import com.example.CourseService.controllers.course.mapper.CoursesToResponseMapper;
import com.example.CourseService.controllers.course.mapper.CreateRequestToCourseMapper;
import com.example.CourseService.services.course.CourseService;
import com.example.CourseService.controllers.course.dto.CourseResponse;
import com.example.CourseService.controllers.course.dto.CreateCourseRequest;
import com.example.CourseService.controllers.course.dto.UpdateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseService.controllers.course.dto.CoursesResponse;
import com.example.CourseService.services.university.UniversityService;

import java.util.UUID;
import lombok.extern.java.Log;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class CourseControllerImplementation implements CourseController {
    private final CourseService courseService;
    private final UniversityService universityService;

    private final CourseToResponseMapper courseToResponseMapper;
    private final CoursesToResponseMapper coursesToResponseMapper;
    private final CreateRequestToCourseMapper createRequestToCourseMapper;

    @Autowired
    public CourseControllerImplementation(CourseService courseService,
                                          UniversityService universityService,
                                          CourseToResponseMapper courseToResponseMapper,
                                          CoursesToResponseMapper coursesToResponseMapper,
                                          CreateRequestToCourseMapper createRequestToCourseMapper) {
        this.courseService = courseService;
        this.universityService = universityService;
        this.courseToResponseMapper = courseToResponseMapper;
        this.coursesToResponseMapper = coursesToResponseMapper;
        this.createRequestToCourseMapper = createRequestToCourseMapper;
    }
    @Override
    public CoursesResponse getCourses() {
        return coursesToResponseMapper.apply(courseService.findAll());
    }
    @Override
    public CourseResponse getCourse(UUID uuid) {
        return courseService.findById(uuid)
                .map(courseToResponseMapper)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course does not exist"));
    }

    @Override
    public CoursesResponse getCoursesByUniversity(UUID uuid) {
        var university = universityService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));

        return coursesToResponseMapper.apply(courseService.findByUniversity(university));
    }

    @Override
    public CourseResponse createCourse(UUID uuid, CreateCourseRequest request) {

        var university = universityService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));

        var course = createRequestToCourseMapper.apply(request);
        course.setUniversity(university);
        courseService.create(course);

        return courseToResponseMapper.apply(course);
    }

    @Override
    public CourseResponse updateCourse(UUID uuid, UpdateCourseRequest request) {
        var character = courseService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        if (request.getName() != null) {
            character.setName(request.getName());
        }
        if (request.getCredits() != null) {
            character.setCredits(request.getCredits());
        }

        courseService.update(character);

        return courseToResponseMapper.apply(character);
    }

    @Override
    public void deleteCourse(UUID uuid) {
        if (courseService.findById(uuid).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        courseService.delete(uuid);
    }
}
