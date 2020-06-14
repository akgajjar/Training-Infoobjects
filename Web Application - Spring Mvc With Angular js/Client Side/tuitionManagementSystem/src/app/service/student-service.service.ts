import { TmsUtils } from './../app-utils';
import { Constants } from './../app-constants';
import { Teacher } from './../DTO/Teacher';
import { Student } from '../DTO/Student';
import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpResponse,
  HttpHeaders,
  HttpParams,
  HttpEvent,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  students: Student[];
  studentId: string;

  constructor(private _httpService: HttpClient) {}

  getStudents(): Observable<Student[]> {
    return this._httpService.get<Student[]>(Constants.getAllStudentsApi).pipe(
      map((response) => response),
      catchError((error: HttpResponse<Student[]>) => {
        console.log(error);
        return Observable.throw(error);
      })
    );
  }

  insertStudent(student: Student) {
    let body = JSON.stringify(student);
    let headers = new HttpHeaders({ 'Content-Type': Constants.contentType });
    let options = { headers: headers };
    console.log(body);
    return this._httpService.post(Constants.insertStudentApi, body, options);
  }

  updateStudent(student: Student) {
    let body = JSON.stringify(student);
    let headers = new HttpHeaders({ 'Content-Type': Constants.contentType });
    let options = { headers: headers };
    console.log(body);
    return this._httpService.put(
      TmsUtils.stringConcat(Constants.updateStudentApi, student.studentId),
      body,
      options
    );
  }

  deleteStudent(studentId: string) {
    return this._httpService.delete(
      TmsUtils.stringConcat(Constants.deleteStudentApi, studentId)
    );
  }

  getStudentById(studentId: string): Observable<Student> {
    return this._httpService
      .get<Student>(
        TmsUtils.stringConcat(Constants.getStudentByIdApi, studentId)
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
