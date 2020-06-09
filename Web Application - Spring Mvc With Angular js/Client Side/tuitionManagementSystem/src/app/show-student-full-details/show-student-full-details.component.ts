import { Student } from './../DTO/Student';
import { StudentService } from './../service/student-service.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-student-full-details',
  templateUrl: './show-student-full-details.component.html',
  styleUrls: ['./show-student-full-details.component.css',
              '../../assets/css/showfulldetails.css',
              '../../assets/css/style.css']
})
export class ShowStudentFullDetailsComponent implements OnInit {

  selectedStudent : Student;

  constructor(
    private _studentService: StudentService,
    private _router: Router
  ) {
    this.selectedStudent = new Student();
    this.getStudentById();
 }

  ngOnInit(): void {
  }

  getStudentById () {
    this._studentService.getStudentById(this._studentService.studentId).subscribe(
      (studentData) => {
        (this.selectedStudent = studentData), console.log(studentData);
        this._studentService.studentId = '';
      },
      (error) => {
        console.log(error);
      }
    );
  }

  showAllStudents(){
    this._studentService.getStudents().subscribe(
      (studentData) => {
        (this._studentService.students = studentData), console.log(studentData);this._router.navigate(['/student/showAll']);
      },
      (error) => {
        console.log(error);
      }
    );
  }



}
