import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../../api/university/service/university.service';
import { Universities } from '../../api/university/model/universities';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import {CourseService} from '../../api/course/service/course.service';
import {Courses} from '../../api/course/model/courses';

@Component({
  selector: 'app-course-list-view',
  standalone: true,
  imports: [
    MatListModule,
    MatDividerModule,
    MatButtonModule,
    RouterLink,
    MatIconModule,
    ViewTitleComponent,
  ],
  templateUrl: './course-list-view.component.html',
  styleUrl: './course-list-view.component.css',
})
export class CourseListViewComponent implements OnInit {
  constructor(private courseService: CourseService) {}

  courses: Courses | undefined;

  ngOnInit(): void {
    this.fetchCourses();
  }

  fetchCourses(): void {
    this.courseService.getAllCourses().subscribe((courses) => {
      this.courses = courses;
    });
  }

  deleteCourse(id: string): void {
    this.courseService.deleteCourse(id).subscribe(() => {
      this.fetchCourses();
    });
  }
}
