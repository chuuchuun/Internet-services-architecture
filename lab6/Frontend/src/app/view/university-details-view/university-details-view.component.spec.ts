import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityDetailsViewComponent } from './university-details-view.component';

describe('UniversityDetailsViewComponent', () => {
  let component: UniversityDetailsViewComponent;
  let fixture: ComponentFixture<UniversityDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UniversityDetailsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UniversityDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
