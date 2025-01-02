import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCourseViewComponent } from './edit-course-view.component';

describe('EditCourseViewComponent', () => {
  let component: EditCourseViewComponent;
  let fixture: ComponentFixture<EditCourseViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCourseViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditCourseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
