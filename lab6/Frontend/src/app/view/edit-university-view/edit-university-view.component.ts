import { Component, OnInit } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { UniversityService } from '../../api/university/service/university.service';
import { University } from '../../api/university/model/university';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UniversityFormComponent } from '../../component/university-form/university-form.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-edit-university-view',
  standalone: true,
  imports: [ViewTitleComponent, UniversityFormComponent, ErrorMessageComponent],
  templateUrl: './edit-university-view.component.html',
  styleUrl: './edit-university-view.component.css',
})
export class EditUniversityViewComponent implements OnInit {
  constructor(
    private universityService: UniversityService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  university: University | undefined;
  message: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.universityService.getUniversityById(params['id']).subscribe({
        next: (university: University) => {
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
    if (this.university === undefined) {
      return;
    }
    this.universityService.updateUniversity(this.university).subscribe({
      next: (university: University) => {
        this.router.navigate(['/universities', university.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
