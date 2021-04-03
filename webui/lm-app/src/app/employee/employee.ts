export class Employee {
    empId: number;
    empName: String;
    empEmail: String;
    empMobileNo : number;
    empDoj : String;
    empDept :String;
    empManagerId : number;
    empLeaveBalance : number;

    constructor(empId:number,empName:String,empEmail:String,empMobileNo:number,empDoj:String,empDept:String,empManagerId:number,empLeaveBalance:number)
    {
        this.empId = empId;
        this.empName=empName;
        this.empEmail=empEmail;
        this.empMobileNo=empMobileNo;
        this.empDoj=empDoj;
        this.empDept=empDept;
        this.empManagerId=empManagerId;
        this.empLeaveBalance=empLeaveBalance;
    }
}
