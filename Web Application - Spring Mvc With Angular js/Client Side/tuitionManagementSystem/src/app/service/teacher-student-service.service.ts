import { TeacherStudent } from './../DTO/TeacherStudent';
import { Teacher } from './../DTO/Teacher';
import { Student } from './../DTO/Student';
import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpHeaders, HttpParams,HttpEvent,HttpErrorResponse} from "@angular/common/http";
import {Observable, of} from "rxjs";
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TeacherStudentService {

  teacherStudents : TeacherStudent[];

  constructor(private _httpService : HttpClient) { }

  getStudentsForMapping() : Observable<Student[]>{
    return this._httpService.get<Student[]>("http://localhost:8080/tms/teacherStudent/mapping")
      .pipe(map(response  => response),  catchError((error: HttpResponse<Student[]>) => {
       console.log(error);
       return Observable.throw(error);
     }));
  }

  getTeachersForMapping(studentId : string) : Observable<Teacher[]>{
    return this._httpService.get<Teacher[]>("http://localhost:8080/tms/teacherStudent/mapping/" + studentId)
      .pipe(map(response  => response),  catchError((error: HttpResponse<Teacher[]>) => {
       console.log(error);
       return Observable.throw(error);
     }));
  }

  insertTeacherStudent(teacherStudent : TeacherStudent){
    let body =JSON.stringify(teacherStudent);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    return this._httpService.post("http://localhost:8080/tms/teacherStudent", body, options);
  }

  getTeacherStudents() : Observable<TeacherStudent[]>{
    return this._httpService.get<TeacherStudent[]>("http://localhost:8080/tms/teacherStudent")
      .pipe(map(response  => response),  catchError((error: HttpResponse<TeacherStudent[]>) => {
       console.log(error);
       return Observable.throw(error);
     }));
  }

  deleteTeacherStudent(studentId : string, teacherId : string){
    return this._httpService.delete("http://localhost:8080/tms//teacherStudent/" + studentId + "/" + teacherId);
  }


}
