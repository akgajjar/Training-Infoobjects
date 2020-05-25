import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertTeacherStudentMappingComponent } from './insert-teacher-student-mapping.component';

describe('InsertTeacherStudentMappingComponent', () => {
  let component: InsertTeacherStudentMappingComponent;
  let fixture: ComponentFixture<InsertTeacherStudentMappingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertTeacherStudentMappingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertTeacherStudentMappingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
