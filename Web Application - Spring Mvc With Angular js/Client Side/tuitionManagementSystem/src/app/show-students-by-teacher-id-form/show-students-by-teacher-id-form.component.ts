import { Teacher } from './../DTO/Teacher';
import { TeacherService } from './../service/teacher-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-students-by-teacher-id-form',
  templateUrl: './show-students-by-teacher-id-form.component.html',
  styleUrls: ['./show-students-by-teacher-id-form.component.css',
              '../../assets/css/style.css']
})
export class ShowStudentsByTeacherIdFormComponent implements OnInit {

  teachers : Teacher[];
  teacherId : string;

  constructor(private _router : Router,
    private _teacherService : TeacherService) { }

  ngOnInit(): void {
  }

  showStudentsByTeacherId(){
    this._teacherService.teacherId = this.teacherId;
    this._router.navigate(['/teacherStudent/showStudentsByTeacherId']);
  }

}
