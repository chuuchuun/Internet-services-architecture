import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../../api/university/service/university.service';
import { CourseService } from '../../api/course/service/course.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Course } from '../../api/course/model/course';
import { University } from '../../api/university/model/university';
import { CourseFormComponent } from '../../component/course-form/course-form.component';

@Component({
  selector: 'app-add-course-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
    CourseFormComponent,
  ],
  templateUrl: './add-course-view.component.html',
  styleUrl: './add-course-view.component.css',
})
export class AddCourseViewComponent implements OnInit {
  constructor(
    private universityService: UniversityService,
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  message: string = '';
  university: University | undefined;

  ngOnInit() {
    this.route.params.subscribe((params) => {
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

  onSubmit(course: Course): void {
    this.message = '';
    if (!this.university) {
      return;
    }
    this.courseService.createCourse(course, this.university.id).subscribe({
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
