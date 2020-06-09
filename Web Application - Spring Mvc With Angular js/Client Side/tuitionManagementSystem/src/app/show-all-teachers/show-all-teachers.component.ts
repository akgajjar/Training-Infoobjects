import { TeacherService } from './../service/teacher-service.service';
import { Teacher } from './../DTO/Teacher';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-teachers',
  templateUrl: './show-all-teachers.component.html',
  styleUrls: ['./show-all-teachers.component.css',
  '../../assets/css/tablecss/css1.css',
  '../../assets/css/bootstrap.css',
  '../../assets/js/datatable/dataTables.bootstrap.min.css',
  '../../assets/js/datatable/buttons.bootstrap.min.css',
  '../../assets/css/style.css'],
              encapsulation : ViewEncapsulation.None
})
export class ShowAllTeachersComponent implements OnInit {

  title: 'Tuition Management System';
  teachers: Teacher[];

  constructor(
    private _teacherService: TeacherService,
    private _router: Router
  ) {
    this.teachers = this._teacherService.teachers;
    this._teacherService.teachers = [];
  }

  ngOnInit(): void {
  }

  showAllTeachers(){
    this._teacherService.getTeachers().subscribe(
      (teacherData) => {
        (this._teacherService.teachers = teacherData), console.log(teacherData);
        this._router.navigateByUrl('/index').then(() => {
          this._router.navigate(['/teacher/showAll']);
      });
      },
      (error) => {
        console.log(error);
      }
    );
    }

    showFullDetails(teacherId : string){
      this._teacherService.teacherId = teacherId;
      console.log(teacherId);
      this._router.navigate(['/teacher/showFullDetails']);
    }

    updateTeacher(teacherId : string){
      this._teacherService.teacherId = teacherId;
      console.log(teacherId);
      this._router.navigate(['/teacher/update']);
    }

    deleteTeacher(teacherId : string){
      console.log(teacherId);
      this._teacherService.deleteTeacher(teacherId).subscribe(
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
