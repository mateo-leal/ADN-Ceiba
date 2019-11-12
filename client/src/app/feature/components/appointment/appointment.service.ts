import { Injectable } from '@angular/core';

import { AppointmentHttpService } from '@app/core/services/appointment/appointment-http.service';
import { Appointment } from '@app/core/models/appointment';

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
