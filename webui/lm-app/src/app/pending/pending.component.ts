import { Component, OnInit } from '@angular/core';
import { Pending } from './Pending';
import { Observable } from 'rxjs';
import { Employee } from '../employee/employee';
import { LeaveDetails } from '../LeaveDetails';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css']
})
export class PendingComponent implements OnInit {
  leaveArray : number[] = [];
  employees: Employee[];
  leavId : number;
  pending : Pending[];
  empid:number;
  lempid:number;
  check : number;
  showButton:boolean = false;
    myForm: FormGroup;
    id:string;
    indexs:number
    mgrId:number;
    ld = new LeaveDetails(); 
    msg : String;  
    buttonallshow:boolean=false;
    aempId:number;
    aleaveId:number;
    aempData : Observable<Employee>;
    //aleaveData : Observable<Pending>;
    isValidFormSubmitted = false;
    //mockpending:Pending[]=[];
    pend : Observable<Pending[]>;
    user : Observable<Employee[]>;
    pendmock : Pending[]=[];

   constructor(private userService: EmployeeService, private router : Router) { 

   this.pend=userService.getPending(this.empid);
    this.pend.subscribe(vh=>this.pendmock=vh);


     this.empid=parseInt(localStorage.getItem("empId"));
  
     this.userService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
     this.userService.getPending(this.empid).subscribe(data=>this.pending=data,err=>console.log(err));
    //   //this.pending = userService.getPending(this.empid); 
     this.check=parseInt(localStorage.getItem("empId"));
  

   } 
   clickRow(x,e) {
     this.leavId=x.lvdId; 
     localStorage.setItem("leaveId",x.lvdId); 
     console.log(e.empId);
     console.log(e.empName);
     localStorage.setItem("lempId",e.empId);
     localStorage.setItem("leName", e.empName);
     localStorage.setItem("lLeaveBal", e.empLeaveBalance);
     localStorage.setItem("lStartDate", x.lvdStartDate);
     localStorage.setItem("lEndDate", x.lvdEndDate);
     localStorage.setItem("lNoOfDays", x.lvdNoOfDays);
     localStorage.setItem("llvdType", x.lvdLeaveType);
     localStorage.setItem("lReason", x. lvdReason);
     this.showButton=true;
    
   }
  ngOnInit() {
  }
  doApproveDeny() { 
    this.router.navigate(["manager"]);
  }
}
