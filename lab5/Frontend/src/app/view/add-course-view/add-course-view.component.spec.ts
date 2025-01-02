import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCourseViewComponent } from './add-course-view.component';

describe('AddCourseViewComponent', () => {
  let component: AddCourseViewComponent;
  let fixture: ComponentFixture<AddCourseViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCourseViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddCourseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
