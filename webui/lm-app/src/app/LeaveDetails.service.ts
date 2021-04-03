// import { Injectable } from '@angular/core';
// //import { Http, Response } from '@angular/http';
// //import { Observable } from 'rxjs/Rx';
// // import { Employee } from "./employee";
// // import { LeaveDetails } from 'src/app/LeaveDetails';
// import { Observable } from 'rxjs';
// import { HttpClient } from '@angular/common/http';
// import { LeaveDetails } from './leavedetails';

// @Injectable({
//   providedIn: 'root'
// })
// export class LeavedetailsService {
//   [x: string]: any;

//   constructor(private http: HttpClient) {
//   }
//  applyLeavePost():Observable<any>{
//    var empid = localStorage.getItem("empId");
//    var stDate= localStorage.getItem("stDate");
//    var endDate= localStorage.getItem("endDate");
//    var appliedOn= localStorage.getItem("appliedOn");
//    var leaveType= localStorage.getItem("leaveType");
//    var leaveReason= localStorage.getItem("lReason");
//   return this.http.post('http://localhost:8080/ftp93/api/leaveDetails/applyleave/'+empid,
//   { "lvdStartDate":stDate,
//     "lvdEndDate":endDate,
//     "lvdLeaveType":leaveType,
//     "lvdReason":leaveReason});
// }
// getDetails():Observable<LeaveHistory[]>{
//   var empId = localStorage.getItem("empId")
//   return this.http.get<LeaveHistory[]>('http://localhost:8080/ftp93/api/leaveDetails/leaveHistory/' + empId);
// }

// }
