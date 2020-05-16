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
    .subscribe((bookData) => {this.books = bookData, console.log(bookData);}, (error) => {
      console.log(error);
    })
  }

  addBook(): void{
    this._bookService.addBook(this.book)
      .subscribe((response) => {
                  console.log(response);
                  this.reset();
                  this.getBooks();
                }
      ,(error) => {
                  console.log(error);
      });


  }

  private reset(){
    this.book.id = null;
    this.book.title = null;
    this.book.author = null;
  }

  deleteBook(bookId : string){
    this._bookService.deleteBook(bookId)
        .subscribe((response) => {
          console.log(response);
          this.getBooks();
        }
        ,(error) => {
          console.log(error);
        });
  }

  getBookById(bookId : string){
    this._bookService.getBookById(bookId).subscribe((bookData) => {
        console.log(bookData);
        this.book = bookData;
        this.getBooks();
      }
    ,(error) => {
      console.log(error);
    });
  }
}
