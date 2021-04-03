import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  empId;
  empName;
  empEmail;
  empMobile;
  empDoj;
  empDept;
  empLeaveBalance;
  constructor(private router :Router) { }

  ngOnInit() {
   this.empId =  localStorage.getItem("empId");
   this.empName = localStorage.getItem("empName");
   this.empEmail =localStorage.getItem("empEmail");
   this.empMobile = localStorage.getItem("empMobile");
    //localStorage.getItem("empMgrId");
    this.empDoj =localStorage.getItem("empDoj");
   this.empDept = localStorage.getItem("empDept");
    this.empLeaveBalance =localStorage.getItem("empLeaveBalance");
  }
  
  back()
  {
    this.router.navigate(['dashboard']);
  }
    

    
}
