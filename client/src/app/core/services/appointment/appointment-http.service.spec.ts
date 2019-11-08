import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

import { AppointmentHttpService } from './appointment-http.service';

describe('AppointmentHttpService', () => {

  let injector: TestBed;
  let service: AppointmentHttpService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ AppointmentHttpService ]
    });
    injector = getTestBed();
    service = injector.get(AppointmentHttpService);
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
