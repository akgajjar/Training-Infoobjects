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
  styleUrls: ['./insert-teacher.component.css', '../../assets/css/style.css'],
})
export class InsertTeacherComponent implements OnInit {
  title: 'Tuition Management System';
  teacher = new Teacher();

  constructor(
    private _teacherService: TeacherService,
    private _router: Router
  ) {}

  ngOnInit(): void {}

  insertTeacher(): void {
    this._teacherService.insertTeacher(this.teacher).subscribe(
      (response) => {
        console.log(response);
        this._router.navigate(['/index']);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
