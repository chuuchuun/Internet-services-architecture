import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';
import { Course } from '../../api/course/model/course';

@Component({
  selector: 'app-course-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './course-form.component.html',
  styleUrl: './course-form.component.css',
})
export class CourseFormComponent {
  @Input() course: Course = {
    id: '',
    name: '',
    credits: 0
  };
  @Output() submit = new EventEmitter<Course>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.course) {
      this.submit.emit(this.course);
    }
  }
}
