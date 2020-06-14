import { Constants } from './../app-constants';
import { TeacherStudent } from './../DTO/TeacherStudent';
import { Student } from './../DTO/Student';
import { Teacher } from './../DTO/Teacher';
import { TeacherStudentService } from './../service/teacher-student-service.service';
import {
  Component,
  OnInit,
  NgModule,
  CUSTOM_ELEMENTS_SCHEMA,
} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert-teacher-student-mapping',
  templateUrl: './insert-teacher-student-mapping.component.html',
  styleUrls: [
    './insert-teacher-student-mapping.component.css',
    '../../assets/css/bootstrap.css',
    '../../assets/css/style.css',
  ],
})
export class InsertTeacherStudentMappingComponent implements OnInit {
  title: 'Tuition Management System';
  teachers: Teacher[];
  students: Student[];
  teacherStudent: TeacherStudent;

  constructor(
    private _teacherStudentService: TeacherStudentService,
    private _router: Router
  ) {
    this.teacherStudent = new TeacherStudent();
    this.teacherStudent.studentId = '';
    this.teacherStudent.teacherId = '';
  }

  ngOnInit(): void {
    this.getStudentsForMapping();
  }

  getStudentsForMapping() {
    this._teacherStudentService.getStudentsForMapping().subscribe(
      (studentData) => {
        (this.students = studentData), console.log(studentData);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getTeachersForMapping() {
    if (!(this.teacherStudent.studentId.length == 0)) {
      this._teacherStudentService
        .getTeachersForMapping(this.teacherStudent.studentId)
        .subscribe(
          (teacherData) => {
            (this.teachers = teacherData), console.log(teacherData);
          },
          (error) => {
            console.log(error);
          }
        );
    } else {
      this.reset();
    }
  }

  insertTeacherStudent(formState: boolean) {
    if (formState) {
      this._teacherStudentService
        .insertTeacherStudent(this.teacherStudent)
        .subscribe(
          (response) => {
            console.log(response);
            this.reset();
            this.students = [];
            this._router.navigate([Constants.indexMapping]);
          },
          (error) => {
            console.log(error);
          }
        );
    }
  }

  private reset() {
    this.teachers = [];
  }
}
