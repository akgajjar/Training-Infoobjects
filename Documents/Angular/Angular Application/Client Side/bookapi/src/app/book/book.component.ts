import {Component, OnInit, NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {Book} from './book';
import { BookService } from './book.service';



@Component({
    selector : 'app-Book',
    templateUrl : './book.component.html',
    styleUrls : ['./book.component.css'],

})
export class BookComponent implements OnInit{
  title : 'bookAPI'
  books : Book[]
  book = new Book();

  ngOnInit(): void{

    this.getBooks();
  }

  constructor(private _bookService : BookService){}

  getBooks() : void{
    this._bookService.getAllBooks()
    .subscribe((bookData) => {this.books = bookData, console.log(bookData)}, (error) => {
      console.log(error);
    })
  }

  addBook(): void{
    console.log('called');
    this._bookService.addBook(this.book)
      .subscribe((response) => {console.log(response)}, (error) => {
        console.log(error);
      });

  }

}
