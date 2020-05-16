
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
       .pipe(map(response  => response),  catchError((error: HttpResponse<Book[]>) => {
        console.log(error);
        return Observable.throw(error);
      }));
  }

  addBook(book : Book){
    let body =JSON.stringify(book);
    let headers =new HttpHeaders({'Content-Type' : 'application/json'});
    let options = {headers : headers};
    console.log(body);
    if(book.id){
        return this._httpService.put("http://localhost:8080/bookapi/api/book/" + book.id, body, options);
    }
    else {
      return this._httpService.post("http://localhost:8080/bookapi/api/save", body, options);
    }

  }

  deleteBook(bookId : string){
    return this._httpService.delete("http://localhost:8080/bookapi/api/book/" + bookId);
  }

  getBookById(bookId : string) : Observable<Book>{
    return this._httpService.get<Book>("http://localhost:8080/bookapi/api/book/" + bookId)
       .pipe(map(response  => response),  catchError((error: HttpResponse<Book>) => {
        console.log(error);
        return Observable.throw(error);
      }));
  }
}
