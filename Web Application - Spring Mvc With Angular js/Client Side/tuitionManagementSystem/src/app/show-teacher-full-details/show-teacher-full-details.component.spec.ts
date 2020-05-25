import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowTeacherFullDetailsComponent } from './show-teacher-full-details.component';

describe('ShowTeacherFullDetailsComponent', () => {
  let component: ShowTeacherFullDetailsComponent;
  let fixture: ComponentFixture<ShowTeacherFullDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowTeacherFullDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowTeacherFullDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
