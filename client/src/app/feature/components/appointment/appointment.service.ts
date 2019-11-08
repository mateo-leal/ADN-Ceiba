import { Injectable } from '@angular/core';
import { Appointment } from 'src/app/core/models/appointment';
import { AppointmentHttpService } from 'src/app/core/services/appointment/appointment-http.service';

@Injectable()
export class AppointmentService {

  constructor(private appointmentHttpService: AppointmentHttpService) { }

  findAll() {
    return this.appointmentHttpService.findAll();
  }

  delete(appointment: Appointment) {
    return this.appointmentHttpService.delete(appointment.id).toPromise();
  }
}
