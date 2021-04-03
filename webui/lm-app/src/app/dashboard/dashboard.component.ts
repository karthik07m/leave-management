import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee/employee';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  empid ; 
  empName;
  mgrId;
  employees: Employee[];
  constructor(private router :Router,private userService:EmployeeService) { }
  
  ngOnInit() {
   this.empid = localStorage.getItem("empId");
   console.log(this.empid);
   this.empName = localStorage.getItem("empName");
   console.log(this.empName);
   this.mgrId = localStorage.getItem("empMgrId");
   console.log(this.empName);
   this.userService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
  }
  logout()
  {
    this.router.navigate(['/home'])
  }
}
