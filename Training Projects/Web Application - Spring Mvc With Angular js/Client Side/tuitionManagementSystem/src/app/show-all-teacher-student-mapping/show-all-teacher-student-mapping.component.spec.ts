import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllTeacherStudentMappingComponent } from './show-all-teacher-student-mapping.component';

describe('ShowAllTeacherStudentMappingComponent', () => {
  let component: ShowAllTeacherStudentMappingComponent;
  let fixture: ComponentFixture<ShowAllTeacherStudentMappingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllTeacherStudentMappingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllTeacherStudentMappingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
