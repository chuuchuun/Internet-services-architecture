import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../api/course/service/course.service';
import { Course } from '../../api/course/model/course';
import { ActivatedRoute } from '@angular/router';
import { University } from '../../api/university/model/university';
import { UniversityService } from '../../api/university/service/university.service';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-course-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    RouterLink,
    MatButtonModule,
    ErrorMessageComponent,
  ],
  templateUrl: './course-details-view.component.html',
  styleUrl: './course-details-view.component.css',
})
export class CourseDetailsViewComponent implements OnInit {
  constructor(
    private courseService: CourseService,
    private universityService: UniversityService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  university: University | undefined;
  course: Course | undefined;

  ngOnInit() {
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
}
