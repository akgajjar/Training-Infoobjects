import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-show-all-students',
  templateUrl: './show-all-students.component.html',
  styleUrls: ['./show-all-students.component.css',
              '../../assets/css/tablecss/css1.css',
              '../../assets/css/bootstrap.css',
              '../../assets/js/datatable/dataTables.bootstrap.min.css',
              '../../assets/js/datatable/buttons.bootstrap.min.css']
})
export class ShowAllStudentsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
