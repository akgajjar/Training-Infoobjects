import { Constants } from './../app-constants';
import { Teacher } from './../DTO/Teacher';
import { TeacherService } from './../service/teacher-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-teacher-full-details',
  templateUrl: './show-teacher-full-details.component.html',
  styleUrls: [
    './show-teacher-full-details.component.css',
    '../../assets/css/showfulldetails.css',
    '../../assets/css/style.css',
  ],
})
export class ShowTeacherFullDetailsComponent implements OnInit {
  teacher: Teacher;

  constructor(
    private _teacherService: TeacherService,
    private _router: Router
  ) {
    this.teacher = new Teacher();
    this.getTeacherById();
  }

  getTeacherById() {
    this._teacherService
      .getTeacherById(this._teacherService.teacherId)
      .subscribe(
        (teacherData) => {
          (this.teacher = teacherData), console.log(teacherData);
          this._teacherService.teacherId = '';
        },
        (error) => {
          console.log(error);
        }
      );
  }

  ngOnInit(): void {}

  showAllTeachers() {
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this._teacherService.teachers = teacherData), console.log(teacherData);
        this._router.navigate([Constants.showAllTeachersMapping]);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
