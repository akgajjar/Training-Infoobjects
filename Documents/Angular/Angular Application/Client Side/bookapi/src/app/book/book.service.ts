
import {HttpClient, HttpResponse, HttpHeaders, HttpParams,HttpEvent,HttpErrorResponse} from "@angular/common/http";

import{Injectable} from "@angular/core";
import { Book } from "./book";
import {Observable, of} from "rxjs";
import { map, catchError } from 'rxjs/operators';



@Injectable()
export class BookService{

  constructor(private _httpService : HttpClient ){ }

  getAllBooks() : Observable<Book[]>{
     return this._httpService.get<Book[]>("http://localhost:8080/bookapi/api/books")
       .pipe(map(response  => response),  catchError((error: HttpResponse<any>) => {
        console.log(error);
        return Observable.throw(error);
      }));
  }

  addBook(book : Book){
    let body =JSON.stringify(book);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(headers);
    return this._httpService.post("http://localhost:8080/bookapi/api/save", body, options);

  }
}
