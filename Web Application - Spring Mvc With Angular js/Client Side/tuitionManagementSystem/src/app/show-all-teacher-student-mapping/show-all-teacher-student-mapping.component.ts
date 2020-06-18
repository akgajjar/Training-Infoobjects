import { Constants } from './../app-constants';
import { TeacherStudentService } from './../service/teacher-student-service.service';
import { TeacherStudent } from './../DTO/TeacherStudent';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-teacher-student-mapping',
  templateUrl: './show-all-teacher-student-mapping.component.html',
  styleUrls: [
    './show-all-teacher-student-mapping.component.css',
    '../../assets/css/tablecss/css1.css',
    '../../assets/css/bootstrap.css',
    '../../assets/js/datatable/dataTables.bootstrap.min.css',
    '../../assets/js/datatable/buttons.bootstrap.min.css',
    '../../assets/css/style.css',
    '../../../node_modules/font-awesome/css/font-awesome.css',
  ],
  encapsulation: ViewEncapsulation.None,
})
export class ShowAllTeacherStudentMappingComponent implements OnInit {
  teacherStudents: TeacherStudent[];

  constructor(
    private _router: Router,
    private _teacherStudentService: TeacherStudentService
  ) {
    this.teacherStudents = this._teacherStudentService.teacherStudents;
    this._teacherStudentService.teacherStudents = [];
  }

  ngOnInit(): void {}

  showAllTeacherStudent() {
    this._teacherStudentService.getTeacherStudents().subscribe(
      (teacherStudentData) => {
        (this._teacherStudentService.teacherStudents = teacherStudentData),
          console.log(teacherStudentData);
        this._router.navigateByUrl(Constants.indexMapping).then(() => {
          this._router.navigate([Constants.showAllTeacherStudentsMapping]);
        });
      },
      (error) => {
        console.log(error);
      }
    );
  }

  deleteTeacherStudent(studentId: string, teacherId: string) {
    this._teacherStudentService
      .deleteTeacherStudent(studentId, teacherId)
      .subscribe(
        (responseData) => {
          console.log(responseData);
          this.showAllTeacherStudent();
        },
        (error) => {
          console.log(error);
        }
      );
  }
}
