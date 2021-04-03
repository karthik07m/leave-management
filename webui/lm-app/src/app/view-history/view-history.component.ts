import { Component, OnInit } from '@angular/core';

import { LeaveHistory } from './LeaveHistory';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LeaveDetailsService } from '../leave-details.service';


@Component({
  selector: 'app-view-history',
  templateUrl: './view-history.component.html',
  styleUrls: ['./view-history.component.css']
})

 export class ViewHistoryComponent implements OnInit {
  ld : LeaveHistory[];
    employOb : Observable<LeaveHistory[]>;
    hismock : LeaveHistory[]=[];
    constructor(private history: LeaveDetailsService, private router:Router) {
      this.employOb = history.getDetails();
      this.employOb.subscribe(vh=>this.hismock=vh);
      this.history.getDetails().subscribe(l=>this.ld =l);
     }
  ngOnInit() {
  
  }

  applyLeave (){
  this.router.navigate(['applyleave']);
  }
}
