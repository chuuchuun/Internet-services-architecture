import com.example.demo.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseEventPublisher eventPublisher;

    public CourseService(CourseRepository courseRepository, CourseEventPublisher eventPublisher) {
        this.courseRepository = courseRepository;
        this.eventPublisher = eventPublisher;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
        eventPublisher.publishCourseEvent(new CourseEventDto("COURSE_ADDED", course.getCourseId(), course.getCourseName(), course.getUniversityId()));
    }

    public void removeCourse(UUID courseId) {
        courseRepository.deleteById(courseId);
        eventPublisher.publishCourseEvent(new CourseEventDto("COURSE_REMOVED", courseId, null, null));
    }
}
