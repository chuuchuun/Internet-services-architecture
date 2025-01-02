import { Component, OnInit } from '@angular/core';
import { UniversityService } from '../../api/university/service/university.service';
import { Universities } from '../../api/university/model/universities';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';

@Component({
  selector: 'app-university-list-view',
  standalone: true,
  imports: [
    MatListModule,
    MatDividerModule,
    MatButtonModule,
    RouterLink,
    MatIconModule,
    ViewTitleComponent,
  ],
  templateUrl: './university-list-view.component.html',
  styleUrl: './university-list-view.component.css',
})
export class UniversityListViewComponent implements OnInit {
  constructor(private universityService: UniversityService) {}

  universities: Universities | undefined;

  ngOnInit(): void {
    this.fetchUniversities();
  }

  fetchUniversities(): void {
    this.universityService.getAllUniversities().subscribe((universities) => {
      this.universities = universities;
    });
  }

  deleteUniversity(id: string): void {
    this.universityService.deleteUniversity(id).subscribe(() => {
      this.fetchUniversities();
    });
  }
}
