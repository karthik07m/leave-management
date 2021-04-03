import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee/employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-details',
  templateUrl: './manager-details.component.html',
  styleUrls: ['./manager-details.component.css']
})
export class ManagerDetailsComponent implements OnInit {

  constructor(private employeeService: EmployeeService, private router :Router) { }
  employees: Employee[];

  getEmployeeById(): void {
      this.employeeService.getEmployeeById().subscribe(data=>this.employees=data,err=>console.log(err));

  }
  ngOnInit() {
    this.getEmployeeById();
  }

  
  back()
  {
    this.router.navigate(['dashboard']);
  }
}
