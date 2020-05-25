import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { IndexComponent } from './index/index.component';
import { LoadScriptDirectiveDirective } from './load-script-directive.directive';
import { InsertStudentComponent } from './insert-student/insert-student.component';
import { InsertTeacherComponent } from './insert-teacher/insert-teacher.component';
import { InsertTeacherStudentMappingComponent } from './insert-teacher-student-mapping/insert-teacher-student-mapping.component';
import { ShowStudentFullDetailsComponent } from './show-student-full-details/show-student-full-details.component';
import { ShowStudentsByTeacherIdComponent } from './show-students-by-teacher-id/show-students-by-teacher-id.component';
import { ShowStudentsByTeacherIdFormComponent } from './show-students-by-teacher-id-form/show-students-by-teacher-id-form.component';
import { ShowTeacherFullDetailsComponent } from './show-teacher-full-details/show-teacher-full-details.component';
import { ShowTeacherNameComponent } from './show-teacher-name/show-teacher-name.component';
import { UpdateTeacherComponent } from './update-teacher/update-teacher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ShowAllStudentsComponent } from './show-all-students/show-all-students.component';
import { ShowAllTeachersComponent } from './show-all-teachers/show-all-teachers.component';
import { ShowAllTeacherStudentMappingComponent } from './show-all-teacher-student-mapping/show-all-teacher-student-mapping.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    LoadScriptDirectiveDirective,
    InsertStudentComponent,
    InsertTeacherComponent,
    InsertTeacherStudentMappingComponent,
    ShowStudentFullDetailsComponent,
    ShowStudentsByTeacherIdComponent,
    ShowStudentsByTeacherIdFormComponent,
    ShowTeacherFullDetailsComponent,
    ShowTeacherNameComponent,
    UpdateTeacherComponent,
    UpdateStudentComponent,
    ShowAllStudentsComponent,
    ShowAllTeachersComponent,
    ShowAllTeacherStudentMappingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas : [NO_ERRORS_SCHEMA]
})
export class AppModule { }
