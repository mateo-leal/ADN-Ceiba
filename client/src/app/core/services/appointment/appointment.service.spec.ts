import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

import { AppointmentService } from './appointment.service';

describe('AppointmentService', () => {

  let injector: TestBed;
  let service: AppointmentService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ AppointmentService ]
    });
    injector = getTestBed();
    service = injector.get(AppointmentService);
    httpMock = injector.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should return an Observable<Appointment[]>', () => {
    service.findAll().subscribe(appointments => {
      expect(appointments).not.toBeNull();
    });

    const req = httpMock.expectOne(`${service.api}`);
    expect(req.request.method).toBe('GET');
  });
});
