import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Courses } from '../model/courses';
import { Observable } from 'rxjs';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private httpClient: HttpClient) {}

  getAllCourses(): Observable<Courses> {
    return this.httpClient.get<Courses>('/api/courses');
  }

  getCourseById(id: string): Observable<Course> {
    return this.httpClient.get<Course>(`/api/courses/${id}`);
  }

  getCoursesByUniversityId(universityId: string): Observable<Courses> {
    return this.httpClient.get<Courses>(
      `/api/universities/${universityId}/courses`,
    );
  }

  createCourse(course: Course, universityId: string): Observable<Course> {
    return this.httpClient.post<Course>(
      `/api/universities/${universityId}/courses`,
      course,
    );
  }

  updateCourse(course: Course): Observable<Course> {
    return this.httpClient.patch<Course>(
      `/api/courses/${course.id}`,
      course,
    );
  }

  deleteCourse(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/courses/${id}`);
  }
}
