import { Component, OnInit } from '@angular/core';
import { LeaveDetails } from '../LeaveDetails';
import { LeaveDetailsService } from '../leave-details.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-manager-actions',
  templateUrl: './manager-actions.component.html',
  styleUrls: ['./manager-actions.component.css']
})
export class ManagerActionsComponent implements OnInit {
  msg: any
  ld: LeaveDetails[];
  message: string;
  empId;
  empName;
  sDate;
  eDate;
  leaveBal;
  leaveType;
  reason;
  isValidFormSubmitted: boolean;
  constructor(private ldser: LeaveDetailsService, private router :Router) {}
   

  ngOnInit() {
    this.empId = localStorage.getItem("lempId");
    this.empName = localStorage.getItem("leName");
    this.sDate = localStorage.getItem("lStartDate");
    this.eDate = localStorage.getItem("lEndDate");
    this.leaveBal = localStorage.getItem("lLeaveBal");
    this.leaveType =localStorage.getItem("llvdType");
    this.reason = localStorage.getItem("lReason");
  }

  approve(lform) {
    var mComments = lform.value.mc;
    localStorage.setItem("mc", mComments);
    
    this.ldser.getApproveOrDeny().subscribe(
      data => { this.msg = data },
      error => { this.message = error.error.text },
    );
    console.log("Approved");
    console.log(this.msg);
    this.msg;
    this.isValidFormSubmitted = true;
    setTimeout(() => {
      this.router.navigate(['/dashboard'])
    }
    , 10000);

  }
  deny(lform) {
    var mComments = lform.value.mc;
    localStorage.setItem("mc", mComments);
    this.ldser.getApproveOrDeny().subscribe(
      data => {this.msg = data},
      error =>{this.message= error.error.text},
      );
    console.log(this.msg);
    this.msg;
    this.isValidFormSubmitted = true;
    setTimeout(() => {
      this.router.navigate(['/dashboard'])
    }
    , 4000);

  }
  cancel() {
    this.router.navigate(['/dashboard'])
  }

}

