import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../api/course/service/course.service';
import { University } from '../../api/university/model/university';
import { Course } from '../../api/course/model/course';
import { UniversityService } from '../../api/university/service/university.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { CourseFormComponent } from '../../component/course-form/course-form.component';

@Component({
  selector: 'app-edit-course-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, CourseFormComponent],
  templateUrl: './edit-course-view.component.html',
  styleUrl: './edit-course-view.component.css',
})
export class EditCourseViewComponent implements OnInit {
  constructor(
    private courseService: CourseService,
    private universityService: UniversityService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  course: Course | undefined;
  university: University | undefined;
  message: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.courseService.getCourseById(params['courseId']).subscribe({
        next: (course) => {
          this.course = course;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
      this.universityService.getUniversityById(params['universityId']).subscribe({
        next: (university) => {
          this.university = university;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }

  onSubmit(): void {
    this.message = '';
    if (this.course) {
      this.courseService.updateCourse(this.course).subscribe({
        next: (course) => {
          this.router.navigate([
            '/universities',
            this.university?.id,
            'courses',
            course.id,
          ]);
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    }
  }
}
