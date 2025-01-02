import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityListViewComponent } from './university-list-view.component';

describe('UniversityListViewComponent', () => {
  let component: UniversityListViewComponent;
  let fixture: ComponentFixture<UniversityListViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UniversityListViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UniversityListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
