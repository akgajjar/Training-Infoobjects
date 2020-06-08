import { StudentService } from './../service/student-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css',
              '../../assets/css/style.css']
})
export class IndexComponent implements OnInit {

  constructor(private _router : Router, private _studentService : StudentService) { }

  ngOnInit(): void {
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
