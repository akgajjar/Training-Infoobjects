import { TeacherStudentService } from './../service/teacher-student-service.service';
import { Student } from './../DTO/Student';
import { StudentService } from './../service/student-service.service';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-students',
  templateUrl: './show-all-students.component.html',
  styleUrls: [
    './show-all-students.component.css',
    '../../assets/css/tablecss/css1.css',
    '../../assets/css/bootstrap.css',
    '../../assets/js/datatable/dataTables.bootstrap.min.css',
    '../../assets/js/datatable/buttons.bootstrap.min.css',
    '../../assets/css/style.css'
  ],
  encapsulation : ViewEncapsulation.None
})
export class ShowAllStudentsComponent implements OnInit {
  title: 'Tuition Management System';
  students: Student[];

  constructor(
    private _studentService: StudentService,
    private _router: Router
  ) {
    this.students = this._studentService.students;
    this._studentService.students = [];
  }

  ngOnInit(): void {
   }

  viewFullDetails(studentId : string){
    console.log(studentId);
    this._studentService.studentId = studentId;
    this._router.navigate(['/student/showFullDetails']);
  }

  viewTeacherName(studentId : string){
    console.log(studentId);
    this._studentService.studentId = studentId;
    this._router.navigate(['/student/showTeacherName']);
  }

  updateStudent(studentId : string){
    console.log(studentId);
    this._studentService.studentId = studentId;
    this._router.navigate(['/student/update']);
  }

  showAllStudents(){
    this._studentService.getStudents().subscribe(
      (studentData) => {
        (this._studentService.students = studentData), console.log(studentData);
        this._router.navigateByUrl('/index').then(() => {
            this._router.navigate(['/student/showAll']);
        });
      },
      (error) => {
        console.log(error);
      }
    );
    }

  deleteStudent(studentId : string){
    console.log(studentId);

    this._studentService.deleteStudent(studentId).subscribe(
      (responseMessage) => {
        console.log(responseMessage);
        this.showAllStudents();
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
