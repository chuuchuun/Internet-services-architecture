import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUniversityViewComponent } from './add-university-view.component';

describe('AddUniversityViewComponent', () => {
  let component: AddUniversityViewComponent;
  let fixture: ComponentFixture<AddUniversityViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddUniversityViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddUniversityViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
