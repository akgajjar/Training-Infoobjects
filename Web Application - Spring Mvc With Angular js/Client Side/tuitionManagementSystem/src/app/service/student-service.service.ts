import { Student } from '../DTO/Student';
import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpHeaders, HttpParams,HttpEvent,HttpErrorResponse} from "@angular/common/http";
import {Observable, of} from "rxjs";
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  students :Student[];

  constructor(private _httpService : HttpClient) { }

  getStudents() : Observable<Student[]>{
    return this._httpService.get<Student[]>("http://localhost:8080/tms/student")
      .pipe(map(response  => response),  catchError((error: HttpResponse<Student[]>) => {
       console.log(error);
       return Observable.throw(error);
     }));
  }

  insertStudent(student : Student){
    let body =JSON.stringify(student);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    return this._httpService.post("http://localhost:8080/tms/student", body, options);
  }

  updateStudent(student : Student){
    let body =JSON.stringify(student);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    return this._httpService.put("http://localhost:8080/tms/student/" + student.studentId, body, options);
  }

  deleteStudent(studentId : string){
    return this._httpService.delete("http://localhost:8080/tms/student/" + studentId);
  }

  getStudentById(studentId : string): Observable<Student>{
    return this._httpService.get<Student>("http://localhost:8080/tms/student/" + studentId)
    .pipe(map(response  => response),  catchError((error: HttpResponse<Student>) => {
     console.log(error);
     return Observable.throw(error);
   }));
  }
}
