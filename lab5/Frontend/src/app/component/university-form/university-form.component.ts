import { Component, EventEmitter, Input, Output } from '@angular/core';
import { University } from '../../api/university/model/university';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';

@Component({
  selector: 'app-university-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './university-form.component.html',
  styleUrl: './university-form.component.css',
})
export class UniversityFormComponent {
  @Input() university: University = {
    id: '',
    name: '',
    location: ''
  };
  @Output() submit = new EventEmitter<University>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.university) {
      this.submit.emit(this.university);
    }
  }
}
