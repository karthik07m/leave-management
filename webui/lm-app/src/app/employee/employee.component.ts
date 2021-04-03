import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from './employee';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
  providers: [ EmployeeService ]
})
export class EmployeeComponent implements OnInit {
  constructor(private employeeService: EmployeeService, private router :Router) { }

  title = 'Leave Management Application';
  employees: Employee[];

  getEmployees(): void {
      this.employeeService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
    
  }
  navigate(employee)
  {
    localStorage.setItem("empId", employee.empId);
    console.log(localStorage.getItem("empId"));
    localStorage.setItem("empName", employee.empName);
    console.log(localStorage.getItem("empName"));
    localStorage.setItem("empEmail", employee.empEmail);
    console.log(localStorage.getItem("empEmail"));
    localStorage.setItem("empMobile", employee.empMobileNo);
    console.log(localStorage.getItem("empMobile"));
    localStorage.setItem("empMgrId", employee.empManagerId);
    console.log(localStorage.getItem("empMgrId"));
    localStorage.setItem("empDoj", employee.empDoj);
    console.log(localStorage.getItem("empDoj"));
    localStorage.setItem("empDept", employee.empDept);
    console.log(localStorage.getItem("empDept"));
    localStorage.setItem("empLeaveBalance", employee.empLeaveBalance);
    console.log(localStorage.getItem("empLeaveBalance"));
    this.router.navigate(['login']);
    
  }

  ngOnInit(): void {
    this.getEmployees();
  }
}
