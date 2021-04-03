import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeComponent } from './employee.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { Employee } from './employee';
import { Observable, of } from 'rxjs';
import { EmployeeService } from '../employee.service';
class MockEmployeeService {
  getEmployees(): Observable<Employee[]> {
    console.log('Mock getEmployees called');
    return of ([new Employee(1000,"Sri Krishna","krishna@hexaware.com",	9956992791,"2004-01-20","CEO",16,null)]);
  }
}
describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeComponent ],
      imports:[ HttpClientModule,RouterTestingModule,FormsModule],
      providers: [
        {provide: EmployeeService, useClass: MockEmployeeService }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employees').length).toBe(0);
    });
  }));
});
