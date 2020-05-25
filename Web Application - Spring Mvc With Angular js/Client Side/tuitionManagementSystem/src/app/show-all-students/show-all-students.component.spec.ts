import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllStudentsComponent } from './show-all-students.component';

describe('ShowAllStudentsComponent', () => {
  let component: ShowAllStudentsComponent;
  let fixture: ComponentFixture<ShowAllStudentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllStudentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
