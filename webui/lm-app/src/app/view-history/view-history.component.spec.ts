import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {  ViewHistoryComponent} from './view-history.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { LeaveDetailsService } from '../leave-details.service';

const his = {
  getDetails(){
    console.log('came inside the stub');
    const his =  [
      {
        "empId" : 3001,
        "lvdId" : 4,
        "lvdStartDate" :"2019-01-04",
        "lvdEndDate" :'2019-01-04', 
        "lvdLeaveStatus" :'Pending',
        "lvdReason" : 'fever',
        "lvdAppliedOn" : '2018-12-13',
        "managerComments":'karthik lol',
      },
      {
        "empId" : 3001,
        "lvdId" : 4,
        "lvdStartDate" :"2019-01-04",
        "lvdEndDate" :'2019-01-04', 
        "lvdLeaveStatus" :'Pending',
        "lvdReason" : 'fever',
        "lvdAppliedOn" : '2018-12-13',
        "managerComments":'karthik lol',
      },
    ];
    return of( his );
  }
};
describe('ViewhistoryComponent', () => {
  let component: ViewHistoryComponent;
  let fixture: ComponentFixture<ViewHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [  ViewHistoryComponent ],
      imports : [HttpClientModule,FormsModule, RouterTestingModule],
      providers: [{provide: LeaveDetailsService,
        useValue: his},
        HttpClient,
        ]
    })
    .compileComponents();
  }));


  beforeEach(() => {
    fixture = TestBed.createComponent(ViewHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should Check Id for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].empId).toEqual(3001);
  });
  it('should Check leaveId for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdId).toEqual(4);
  });

  it('should Check startDate for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdStartDate).toEqual("2019-01-04");
  });
  it('should Check EndDate for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdEndDate).toEqual("2019-01-04");
  });
  // it('should Check leaveType for employee', () => {
  //   const fixture = TestBed.createComponent(ViewHistoryComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   expect(app.hismock[0].lvdleaveType).toEqual("EL");
  // });
  it('should Check leaveStatus for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdLeaveStatus).toEqual("Pending");
  });
  it('should Check leaveReason for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdReason).toEqual("fever");
  });
  it('should Check leaveAppliedOn for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].lvdAppliedOn).toEqual("2018-12-13");
  });
  it('should Check leaveManagerComments for employee', () => {
    const fixture = TestBed.createComponent(ViewHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].managerComments).toEqual("karthik lol");
  });
});
