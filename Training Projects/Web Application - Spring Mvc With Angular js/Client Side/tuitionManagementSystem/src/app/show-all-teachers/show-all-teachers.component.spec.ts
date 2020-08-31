import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllTeachersComponent } from './show-all-teachers.component';

describe('ShowAllTeachersComponent', () => {
  let component: ShowAllTeachersComponent;
  let fixture: ComponentFixture<ShowAllTeachersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllTeachersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllTeachersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
