import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowTeacherNameComponent } from './show-teacher-name.component';

describe('ShowTeacherNameComponent', () => {
  let component: ShowTeacherNameComponent;
  let fixture: ComponentFixture<ShowTeacherNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowTeacherNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowTeacherNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
