import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms/src/directives/ng_form';

import { Router } from '@angular/router';
import { LeaveDetailsService } from '../leave-details.service';



@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css'],
})
export class ApplyLeaveComponent implements OnInit {
  msg:string;
  empId:number;
  isValidFormSubmitted: boolean;
   

  constructor(public applyLeaveService:LeaveDetailsService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    
  
   }
   display(sForm){
 
    var sDate = sForm.value.sdate;
    localStorage.setItem("stDate",sDate);
    var eDate = sForm.value.edate;
    localStorage.setItem("endDate",eDate);
    var appliedon = sForm.value.adate;
    localStorage.setItem("appliedOn",appliedon)
    var  leaveType = sForm.value.ltype;
    localStorage.setItem("leaveType",leaveType)
    var leaveReason = sForm.value.reason;
    localStorage.setItem("lReason",leaveReason);
 
    console.log(sDate),
    console.log(eDate),
    console.log(appliedon),
    console.log(leaveType),
    console.log(leaveReason),
    this.applyLeaveService.applyLeavePost().subscribe(
      data=>{this.msg = data},
      error=> {this.msg = error.error.text});
    console.log(this.msg)
    this.isValidFormSubmitted = true;
    
    setTimeout(() => {
      this.router.navigate(['/dashboard'])
    }
    , 4000);

  }
  ngOnInit() {
 
  }

  
}
