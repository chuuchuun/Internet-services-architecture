import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditUniversityViewComponent } from './edit-university-view.component';

describe('EditUniversityViewComponent', () => {
  let component: EditUniversityViewComponent;
  let fixture: ComponentFixture<EditUniversityViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditUniversityViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditUniversityViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
