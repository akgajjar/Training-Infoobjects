import { StudentService } from './../service/student-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../DTO/Student';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css',
              '../../assets/css/style.css']
})
export class UpdateStudentComponent implements OnInit {

  student : Student;

  constructor(
    private _studentService: StudentService,
    private _router: Router
  ) {
      this.student = new Student();
      this.getStudent();
  }

  getStudent(){
    this._studentService.getStudentById(this._studentService.studentId).subscribe(
      (studentData) => {
        console.log(studentData);
        this.student = studentData;
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

  updateStudent(){
    console.log('Update Student Called');
    this._studentService.updateStudent(this.student).subscribe(
      (responseMessage) =>{
        console.log(responseMessage);
        this.showAllStudents();
      } ,
      (error) => {
        console.log(error);
      });
  }

  ngOnInit(): void {
  }

}
