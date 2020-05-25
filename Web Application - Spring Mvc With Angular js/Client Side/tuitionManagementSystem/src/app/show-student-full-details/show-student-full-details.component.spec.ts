import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowStudentFullDetailsComponent } from './show-student-full-details.component';

describe('ShowStudentFullDetailsComponent', () => {
  let component: ShowStudentFullDetailsComponent;
  let fixture: ComponentFixture<ShowStudentFullDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowStudentFullDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowStudentFullDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
