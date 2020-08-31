import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertTeacherComponent } from './insert-teacher.component';

describe('InsertTeacherComponent', () => {
  let component: InsertTeacherComponent;
  let fixture: ComponentFixture<InsertTeacherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertTeacherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
