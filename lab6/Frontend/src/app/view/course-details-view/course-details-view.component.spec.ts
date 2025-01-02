import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseDetailsViewComponent } from './course-details-view.component';

describe('CourseDetailsViewComponent', () => {
  let component: CourseDetailsViewComponent;
  let fixture: ComponentFixture<CourseDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseDetailsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CourseDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
