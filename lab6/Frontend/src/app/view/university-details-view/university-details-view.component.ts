import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../../api/university/service/university.service';
import { University } from '../../api/university/model/university';
import { ActivatedRoute } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import {Courses} from '../../api/course/model/courses';
import { CourseService } from '../../api/course/service/course.service';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-university-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    MatButtonModule,
    RouterLink,
    MatListModule,
    MatIconModule,
    ErrorMessageComponent,
  ],
  templateUrl: './university-details-view.component.html',
  styleUrl: './university-details-view.component.css',
})
export class UniversityDetailsViewComponent implements OnInit {
  constructor(
    private universityService: UniversityService,
    private courseService: CourseService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  university: University | undefined;
  courses: Courses | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.universityService.getUniversityById(params['id']).subscribe({
        next: (university: University) => {
          this.university = university;
          this.fetchCourses();
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }

  fetchCourses(): void {
    if (this.university) {
      this.courseService.getCoursesByUniversityId(this.university.id).subscribe({
        next: (courses: Courses) => {
          this.courses = courses;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    }
  }

  deleteCourse(id: string): void {
    this.courseService.deleteCourse(id).subscribe(() => {
      this.fetchCourses();
    });
  }
}
