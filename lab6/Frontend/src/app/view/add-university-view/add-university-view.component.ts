import { Component } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { UniversityService } from '../../api/university/service/university.service';
import { University } from '../../api/university/model/university';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Router } from '@angular/router';
import { UniversityFormComponent } from '../../component/university-form/university-form.component';

@Component({
  selector: 'app-add-university-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, UniversityFormComponent],
  templateUrl: './add-university-view.component.html',
  styleUrl: './add-university-view.component.css',
})
export class AddUniversityViewComponent {
  constructor(
    private universityService: UniversityService,
    private router: Router
  ) {}

  message: string = '';

  onSubmit(university: University): void {
    this.message = '';
    this.universityService.createUniversity(university).subscribe({
      next: (university: University) => {
        this.router.navigate(['/universities', university.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
