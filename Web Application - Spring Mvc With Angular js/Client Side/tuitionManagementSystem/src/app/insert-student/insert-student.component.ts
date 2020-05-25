import { StudentService } from './../service/student-service.service';
import { Student } from '../DTO/Student';
import {Component, OnInit, NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert-student',
  templateUrl: './insert-student.component.html',
  styleUrls: ['./insert-student.component.css',
              '../../assets/css/style.css']
})
export class InsertStudentComponent implements OnInit {

  title : 'Tuition Management System';
  student = new Student();

  constructor(private _studentService : StudentService, private _router : Router) { }

  ngOnInit(): void {}

  insertStudent() : void{
    this._studentService.insertStudent(this.student)
    .subscribe((response) => {
                console.log(response);
                this._router.navigate(['/index']);
              }
    ,(error) => {
                console.log(error);
    });
  }
}
