import { Employee } from './employee/employee';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pending } from './pending/Pending';


@Injectable()
export class EmployeeService {
    constructor(private http: HttpClient) {
    }
getEmployees(): Observable<Employee[]> {
    console.log('getEmployees called on employee.service');
    return this.http.get<Employee[]>('http://localhost:8080/ftp93/api/employees');  
}

getEmployeeById(): Observable<Employee[]> {
    console.log('getEmployees called on employee.service');
   var emp = localStorage.getItem("empMgrId");
   console.log("Manager Id : "+emp)
    return this.http.get<Employee[]>('http://localhost:8080/ftp93/api/employees/' + emp );  
}

getEmp(empid): Observable<Employee> {
    return this.http.get<Employee>("http://localhost:8080/ftp93/api/employees/" +empid);

}
getPending(empid):Observable<Pending[]> {
    //var empId = localStorage.getItem("empId")
    return this.http.get<Pending[]>("http://localhost:8080/ftp93/api/leaveDetails/pending/" + empid);
  }
}