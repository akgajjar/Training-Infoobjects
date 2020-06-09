import { Teacher } from './../DTO/Teacher';
import { TeacherService } from './../service/teacher-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-teacher',
  templateUrl: './update-teacher.component.html',
  styleUrls: ['./update-teacher.component.css',
              '../../assets/css/style.css']
})
export class UpdateTeacherComponent implements OnInit {

  teacher : Teacher;

  constructor(
    private _router : Router,
    private _teacherService : TeacherService
  ) {
    this.teacher = new Teacher();
    this.getTeacherById();
   }

  ngOnInit(): void {}

  showAllTeachers(){
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this._teacherService.teachers = teacherData),
        console.log(teacherData);
        this._router.navigate(['/teacher/showAll']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getTeacherById(){
    this._teacherService.getTeacherById(this._teacherService.teacherId).subscribe(
      (teacherData) => {
        (this.teacher = teacherData), console.log(teacherData);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  updateTeacher(){
    this._teacherService.updateTeacher(this.teacher).subscribe(
      (teacherData) => {
         console.log(teacherData);
         this.showAllTeachers();
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
