import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerActionsComponent } from './manager-actions.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';

describe('ManagerActionsComponent', () => {
  let component: ManagerActionsComponent;
  let fixture: ComponentFixture<ManagerActionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerActionsComponent ],
      imports:[ HttpClientModule,RouterTestingModule,FormsModule],
      providers:[EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
