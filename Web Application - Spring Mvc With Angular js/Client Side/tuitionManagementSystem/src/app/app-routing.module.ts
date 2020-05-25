import { ShowAllTeacherStudentMappingComponent } from './show-all-teacher-student-mapping/show-all-teacher-student-mapping.component';
import { UpdateTeacherComponent } from './update-teacher/update-teacher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ShowTeacherNameComponent } from './show-teacher-name/show-teacher-name.component';
import { ShowTeacherFullDetailsComponent } from './show-teacher-full-details/show-teacher-full-details.component';
import { ShowStudentsByTeacherIdFormComponent } from './show-students-by-teacher-id-form/show-students-by-teacher-id-form.component';
import { ShowStudentsByTeacherIdComponent } from './show-students-by-teacher-id/show-students-by-teacher-id.component';
import { ShowStudentFullDetailsComponent } from './show-student-full-details/show-student-full-details.component';
import { InsertTeacherStudentMappingComponent } from './insert-teacher-student-mapping/insert-teacher-student-mapping.component';
import { InsertTeacherComponent } from './insert-teacher/insert-teacher.component';
import { InsertStudentComponent } from './insert-student/insert-student.component';
import { IndexComponent } from './index/index.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowAllStudentsComponent } from './show-all-students/show-all-students.component';
import { ShowAllTeachersComponent } from './show-all-teachers/show-all-teachers.component';

const routes: Routes = [
 {path : '',  redirectTo : '/index', pathMatch : 'full'},
 {path : 'index',  component : IndexComponent},
 {path : 'student/insert', component : InsertStudentComponent},
 {path : 'teacher/insert', component : InsertTeacherComponent},
 {path : 'teacherStudent/insert', component : InsertTeacherStudentMappingComponent},
 {path : 'student/update', component : UpdateStudentComponent},
 {path : 'teacher/update', component : UpdateTeacherComponent},
 {path : 'student/showAll', component : ShowAllStudentsComponent},
 {path : 'teacher/showAll', component : ShowAllTeachersComponent},
 {path : 'teacherStudent/showAll', component : ShowAllTeacherStudentMappingComponent},
 {path : 'student/showFullDetails', component : ShowStudentFullDetailsComponent},
 {path : 'teacher/showFullDetails', component : ShowTeacherFullDetailsComponent},
 {path : 'teacherStudent/showStudentsByTeacherId', component : ShowStudentsByTeacherIdComponent},
 {path : 'teacherStudent/showStudentsByTeacherIdForm', component : ShowStudentsByTeacherIdFormComponent},
 {path : 'student/showTeacherName', component : ShowTeacherNameComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
