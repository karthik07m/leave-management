import { TestBed, async } from '@angular/core/testing';
import { Http, HttpModule } from '@angular/http';
import { MockBackend } from '@angular/http/testing';

import { AppComponent } from './app.component';


import { EmployeeService } from 'src/app/employee.service';
import { Employee } from 'src/app/employee/employee';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';

class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(3001,"karthik","karthik@gmail.com",9490572189,"11-11-2018","Traniee",2000,12),new Employee(3001,"karthik","karthik@gmail.com",9490572189,"11-11-2018","Traniee",2000,12) ]);
  }
}

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ], imports: [
        RouterTestingModule,HttpModule,FormsModule
      ]
    }).overrideComponent(AppComponent, {
      set: {
        providers: [
          {provide: EmployeeService, useClass: MockEmployeeService }
        ]
      }
    }).compileComponents();
  }));


  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Leave Management Application');
  }));

  // it('should render title in a h1 tag', async(() => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.debugElement.nativeElement;
  //   expect(compiled.querySelector('h1').textContent).toContain('Welcome to Leave Management Application');
  // }));

  // it('should render one employee record', async(() => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //     fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(compiled.querySelectorAll('.employees tr').length).toBe(2);
  //   });
  // }));
});
