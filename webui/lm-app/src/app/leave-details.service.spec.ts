import { TestBed, inject } from '@angular/core/testing';

import { LeaveDetailsService } from './leave-details.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('LeaveDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeaveDetailsService],
      imports :[ HttpClientModule,RouterTestingModule]
    });
  });

  it('should be created', inject([LeaveDetailsService,HttpClientModule], (service: LeaveDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
