import { TmsUtils } from '../app-utils';
import { Constants } from './../app-constants';
import { TeacherStudentService } from './../service/teacher-student-service.service';
import { TeacherService } from './../service/teacher-service.service';
import { StudentService } from './../service/student-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css', '../../assets/css/style.css'],
})
export class IndexComponent implements OnInit {
  constructor(
    private _router: Router,
    private _studentService: StudentService,
    private _teacherService: TeacherService,
    private _teacherStudentService: TeacherStudentService
  ) {}

  ngOnInit(): void {}

  showAllStudents() {
    this._studentService.getStudents().subscribe(
      (studentData) => {
        (this._studentService.students = studentData), console.log(studentData);
        this._router.navigate([Constants.showAllStudentsMapping]);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  showAllTeachers() {
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this._teacherService.teachers = teacherData), console.log(teacherData);
        this._router.navigate([Constants.showAllTeachersMapping]);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  showAllTeacherStudents() {
    this._teacherStudentService.getTeacherStudents().subscribe(
      (teacherStudentData) => {
        (this._teacherStudentService.teacherStudents = teacherStudentData),
          console.log(teacherStudentData);
        this._router.navigate([Constants.showAllTeacherStudentsMapping]);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
