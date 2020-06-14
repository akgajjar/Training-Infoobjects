import { Constants } from './../app-constants';
import { TeacherStudentService } from './../service/teacher-student-service.service';
import { Teacher } from './../DTO/Teacher';
import { StudentService } from './../service/student-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-teacher-name',
  templateUrl: './show-teacher-name.component.html',
  styleUrls: [
    './show-teacher-name.component.css',
    '../../assets/css/showfulldetails.css',
    '../../assets/css/style.css',
  ],
})
export class ShowTeacherNameComponent implements OnInit {
  teachers: Teacher[];

  constructor(
    private _studentService: StudentService,
    private _teacherStudentService: TeacherStudentService,
    private _router: Router
  ) {
    this.getTeachers(this._studentService.studentId);
    this._studentService.studentId = '';
  }

  getTeachers(studentId) {
    this._teacherStudentService
      .getTeacherName(studentId)
      .subscribe((teachers) => {
        this.teachers = teachers;
        console.log(teachers);
      });
  }

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
}
