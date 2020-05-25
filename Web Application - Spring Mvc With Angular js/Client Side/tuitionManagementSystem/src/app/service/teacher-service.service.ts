import { Teacher } from '../DTO/Teacher';
import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpHeaders, HttpParams,HttpEvent,HttpErrorResponse} from "@angular/common/http";
import {Observable, of} from "rxjs";
import { map, catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private _httpService : HttpClient) { }

  getTeachers() : Observable<Teacher[]>{
    return this._httpService.get<Teacher[]>("http://localhost:8080/tms/teacher")
      .pipe(map(response  => response),  catchError((error: HttpResponse<Teacher[]>) => {
       console.log(error);
       return Observable.throw(error);
     }));
  }

  insertTeacher(teacher : Teacher){
    let body =JSON.stringify(teacher);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    return this._httpService.post("http://localhost:8080/tms/teacher", body, options);
  }

  updateStudent(teacher : Teacher){
    let body =JSON.stringify(teacher);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    return this._httpService.put("http://localhost:8080/tms/teacher/" + teacher.teacherId, body, options);
  }

  deleteTeacher(teacherId : string){
    return this._httpService.delete("http://localhost:8080/tms/teacher/" + teacherId);
  }

  getTeacherById(teacherId : string): Observable<Teacher>{
    return this._httpService.get<Teacher>("http://localhost:8080/tms/teacher/" + teacherId)
    .pipe(map(response  => response),  catchError((error: HttpResponse<Teacher>) => {
     console.log(error);
     return Observable.throw(error);
   }));
  }

}
