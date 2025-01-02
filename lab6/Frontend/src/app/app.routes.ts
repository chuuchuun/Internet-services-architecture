import { Routes } from '@angular/router';
import { UniversityListViewComponent } from './view/university-list-view/university-list-view.component';
import { AddUniversityViewComponent } from './view/add-university-view/add-university-view.component';
import { EditUniversityViewComponent } from './view/edit-university-view/edit-university-view.component';
import { UniversityDetailsViewComponent } from './view/university-details-view/university-details-view.component';
import { CourseDetailsViewComponent } from './view/course-details-view/course-details-view.component';
import { AddCourseViewComponent } from './view/add-course-view/add-course-view.component';
import { EditCourseViewComponent } from './view/edit-course-view/edit-course-view.component';
import {CourseListViewComponent} from './view/course-list-view/course-list-view.component';


export const routes: Routes = [
  {
      component: UniversityListViewComponent,
      path: 'universities',
    },
    {
      component: AddUniversityViewComponent,
      path: 'universities/new',
    },
    {
      component: UniversityDetailsViewComponent,
      path: 'universities/:id',
    },
    {
      component: EditUniversityViewComponent,
      path: 'universities/:id/edit',
    },
  {
    component: CourseListViewComponent,
    path: 'courses',
  },
    {
      component: AddCourseViewComponent,
      path: 'universities/:universityId/courses/new',
    },
    {
      component: CourseDetailsViewComponent,
      path: 'universities/:universityId/courses/:courseId',
    },
    {
      component: EditCourseViewComponent,
      path: 'universities/:universityId/courses/:courseId/edit',
    },

];
