import { TeacherService } from './../service/teacher-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../DTO/Student';

@Component({
  selector: 'app-show-students-by-teacher-id',
  templateUrl: './show-students-by-teacher-id.component.html',
  styleUrls: ['./show-students-by-teacher-id.component.css',
              '../../assets/css/showfulldetails.css',
              '../../assets/css/style.css']
})
export class ShowStudentsByTeacherIdComponent implements OnInit {

  students : Student[];

  constructor(private _router : Router,
    private _teacherService : TeacherService) {
      this.getStudentsByTeacherId();
     }

  ngOnInit(): void {
  }

  getStudentsByTeacherId(){
    this._teacherService.getStudentsByTeacherId(this._teacherService.teacherId).subscribe(
      (studentData) => {
        (this.students = studentData), console.log(studentData);
        this._teacherService.teacherId = '';
      },
      (error) => {
        console.log(error);
      }
    );
  }

  showAllTeachers(){
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this._teacherService.teachers = teacherData), console.log(teacherData);this._router.navigate(['/teacher/showAll']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
