import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowStudentsByTeacherIdFormComponent } from './show-students-by-teacher-id-form.component';

describe('ShowStudentsByTeacherIdFormComponent', () => {
  let component: ShowStudentsByTeacherIdFormComponent;
  let fixture: ComponentFixture<ShowStudentsByTeacherIdFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowStudentsByTeacherIdFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowStudentsByTeacherIdFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
