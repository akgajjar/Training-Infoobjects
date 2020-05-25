import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowStudentsByTeacherIdComponent } from './show-students-by-teacher-id.component';

describe('ShowStudentsByTeacherIdComponent', () => {
  let component: ShowStudentsByTeacherIdComponent;
  let fixture: ComponentFixture<ShowStudentsByTeacherIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowStudentsByTeacherIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowStudentsByTeacherIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
