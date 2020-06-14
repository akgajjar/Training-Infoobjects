import { Constants } from './../app-constants';
import { Teacher } from './../DTO/Teacher';
import { TeacherService } from './../service/teacher-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-students-by-teacher-id-form',
  templateUrl: './show-students-by-teacher-id-form.component.html',
  styleUrls: [
    './show-students-by-teacher-id-form.component.css',
    '../../assets/css/bootstrap.css',
    '../../assets/css/style.css',
  ],
})
export class ShowStudentsByTeacherIdFormComponent implements OnInit {
  teachers: Teacher[];
  teacherId: string;

  constructor(
    private _router: Router,
    private _teacherService: TeacherService
  ) {
    this.getAllTeachers();
    this.teacherId = '';
  }

  ngOnInit(): void {}

  showStudentsByTeacherId(formState: boolean) {
    if (formState) {
      this._teacherService.teacherId = this.teacherId;
      this._router.navigate([Constants.showStudentsByTeacherIdMapping]);
    }
  }

  getAllTeachers() {
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this.teachers = teacherData), console.log(teacherData);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
