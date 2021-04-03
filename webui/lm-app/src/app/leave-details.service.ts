import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { LeaveHistory } from './view-history/LeaveHistory';
import { Observable } from 'rxjs';
import { Pending } from './pending/Pending';
import { LeaveDetails } from './leavedetails';
@Injectable({
  providedIn: 'root'
})
export class LeaveDetailsService {

  constructor(private http: HttpClient) { }
  getDetails():Observable<LeaveHistory[]>{
    var empId = localStorage.getItem("empId")
    return this.http.get<LeaveHistory[]>('http://localhost:8080/ftp93/api/leaveDetails/leaveHistory/' + empId);
}
getPending():Observable<Pending[]> {
  var empId = localStorage.getItem("empId")
  return this.http.get<Pending[]>("http://localhost:8080/ftp93/api/leaveDetails/pending/" + empId);
}
  getApproveOrDeny(): Observable<any> {
    var lId = localStorage.getItem("leaveId");
    var eId = localStorage.getItem("empId");
    var status = localStorage.getItem("status");
    var ManComments = localStorage.getItem("mc")
    console.log(status);
    console.log("leave id:" + lId);
    console.log("emp id:" + eId);
    console.log("m comments : "+ ManComments)
    return this.http.post<LeaveDetails[]>("http://localhost:8080/ftp93/api/leaveDetails/approvedeny/"+eId+"/"+status,
      {
         "lvdId": lId,
         "empId": eId, 
         "lvdLeaveStatus": status,
         "lvdManagerComments": ManComments,
          });
  }

  applyLeavePost():Observable<any>{
    var empid = localStorage.getItem("empId");
    var stDate= localStorage.getItem("stDate");
    var endDate= localStorage.getItem("endDate");
    var leaveType= localStorage.getItem("leaveType");
    var leaveReason= localStorage.getItem("lReason");
   return this.http.post('http://localhost:8080/ftp93/api/leaveDetails/applyleave/'+empid,
   { "lvdStartDate":stDate,
     "lvdEndDate":endDate,
     "lvdLeaveType":leaveType,
     "lvdReason":leaveReason});
 }
}
