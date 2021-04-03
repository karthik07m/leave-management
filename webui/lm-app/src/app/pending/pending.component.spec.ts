import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingComponent } from './pending.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { of } from 'rxjs';

const user={
  getEmployees(){
    console.log('came inside the stub');
    const user=[
      {
        "empId": 2000,
        "empName": "Vimala",
        "empEmail": "vimala@hexaware.com",
        "empMobileNo": 8908059770,
        "empDoj ": "2003-08-12",
        " empDept ": "Manager",
        "empManagerId":1000,
        "empLeaveBalance ":27,
      
      },
      {
        "empId": 2000,
        "empName": "Vimala",
        "empEmail": "vimala@hexaware.com",
        "empMobileNo": 8908059770,
        "empDoj ": "2003-08-12",
        " empDept ": "Manager",
        "empManagerId":1000,
        "empLeaveBalance ":27,
      }
    ]
  }
}
const pend = {
  getPending(empid){
    console.log('came inside the stub');
    const pend =  [
      {
        "empId" : 2000,
        "leaveId" : 6,
        "leaveNoOfDays" :5,
        "leaveStartDate" :"2019-01-07",
        "leaveEndDate" :'2019-01-12', 
        "leaveType" :'EL' ,
        "leaveStatus" :'Pending',
        "leaveReason" : 'fever',
        "leaveAppliedOn" : '2019-01-03',
        "leaveManagerComments":null,
      },
      {
        "empId" : 2000,
        "leaveId" : 6,
        "leaveNoOfDays" :5,
        "leaveStartDate" :"2019-01-07",
        "leaveEndDate" :'2019-01-12', 
        "leaveType" :'EL' ,
        "leaveStatus" :'Pending',
        "leaveReason" : 'fever',
        "leaveAppliedOn" : '2019-01-03',
        "leaveManagerComments":null,
      },
    ];
    return of( pend );
  }
};
describe('PendingComponent', () => {
  let component: PendingComponent;
  let fixture: ComponentFixture<PendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingComponent ],
      imports:[ HttpClientModule,RouterTestingModule,FormsModule,ReactiveFormsModule],
      //providers:[EmployeeService]
      providers: [{provide:EmployeeService,
        useValue: pend},
        HttpClient,
        ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should Check Id for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].empId).toEqual(2000);
  });
  it('should Check leaveId for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveId).toEqual(6);
  });
  it('should Check leaveNoOfDays for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveNoOfDays).toEqual(5);
  });
  it('should Check startDate for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveStartDate).toEqual("2019-01-07");
  });
  it('should Check EndDate for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveEndDate).toEqual("2019-01-12");
  });
  it('should Check leaveType for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveType).toEqual("EL");
  });
  it('should Check leaveStatus for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveStatus).toEqual("Pending");
  });
  it('should Check leaveReason for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveReason).toEqual("fever");
  });
  it('should Check leaveAppliedOn for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveAppliedOn).toEqual("2019-01-03");
  });
  it('should Check leaveManagerComments for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveManagerComments).toEqual(null);
  });
});
