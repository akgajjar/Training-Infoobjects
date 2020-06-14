import { TmsUtils } from './../app-utils';
import { Constants } from './../app-constants';
import { TeacherStudent } from './../DTO/TeacherStudent';
import { Teacher } from './../DTO/Teacher';
import { Student } from './../DTO/Student';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class TeacherStudentService {
  teacherStudents: TeacherStudent[];

  constructor(private _httpService: HttpClient) {}

  getStudentsForMapping(): Observable<Student[]> {
    return this._httpService
      .get<Student[]>(Constants.getStudentsForMappingApi)
      .pipe(
        map((response) => response),
        catchError((error: HttpResponse<Student[]>) => {
          console.log(error);
          return Observable.throw(error);
        })
      );
  }

  getTeachersForMapping(studentId: string): Observable<Teacher[]> {
    return this._httpService
      .get<Teacher[]>(
        TmsUtils.stringConcat(Constants.getTeacherForMappingApi, studentId)
      )
      .pipe(
        map((response) => response),
        catchError((error: HttpResponse<Teacher[]>) => {
          console.log(error);
          return Observable.throw(error);
        })
      );
  }

  insertTeacherStudent(teacherStudent: TeacherStudent) {
    let body = JSON.stringify(teacherStudent);
    let headers = new HttpHeaders({ 'Content-Type': Constants.contentType });
    let options = { headers: headers };
    console.log(body);
    return this._httpService.post(
      Constants.insertTeacherStudentApi,
      body,
      options
    );
  }

  getTeacherStudents(): Observable<TeacherStudent[]> {
    return this._httpService
      .get<TeacherStudent[]>(Constants.getAllTeacherStudentsApi)
      .pipe(
        map((response) => response),
        catchError((error: HttpResponse<TeacherStudent[]>) => {
          console.log(error);
          return Observable.throw(error);
        })
      );
  }

  deleteTeacherStudent(studentId: string, teacherId: string) {
    return this._httpService.delete(
      TmsUtils.stringConcat(
        Constants.deleteTeacherStudentApi,
        studentId,
        Constants.linkSeperator,
        teacherId
      )
    );
  }

  getTeacherName(studentId: string) {
    return this._httpService
      .get<Teacher[]>(
        TmsUtils.stringConcat(Constants.getTeacherNameApi, studentId)
      )
      .pipe(
        map((response) => response),
        catchError((error: HttpResponse<Student>) => {
          console.log(error);
          return Observable.throw(error);
        })
      );
  }
}
