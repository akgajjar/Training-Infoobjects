import { Constants } from './../app-constants';
import { TeacherService } from './../service/teacher-service.service';
import { Teacher } from './../DTO/Teacher';
import {
  Component,
  OnInit,
  NgModule,
  CUSTOM_ELEMENTS_SCHEMA,
} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert-teacher',
  templateUrl: './insert-teacher.component.html',
  styleUrls: [
    './insert-teacher.component.css',
    '../../assets/css/bootstrap.css',
    '../../assets/css/style.css',
  ],
})
export class InsertTeacherComponent implements OnInit {
  title: 'Tuition Management System';
  teacher: Teacher;

  constructor(
    private _teacherService: TeacherService,
    private _router: Router
  ) {
    this.teacher = new Teacher();
    this.teacher.teacherDesignation = '';
  }

  ngOnInit(): void {}

  insertTeacher(formState: boolean): void {
    if (formState) {
      this._teacherService.insertTeacher(this.teacher).subscribe(
        (response) => {
          console.log(response);
          this._router.navigate([Constants.indexMapping]);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
