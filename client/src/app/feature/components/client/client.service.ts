import { Injectable } from '@angular/core';

import { Client } from '@app/core/models/client';
import { ClientHttpService } from '@app/core/services/client/client-http.service';
import { AppointmentHttpService } from '@app/core/services/appointment/appointment-http.service';

@Injectable()
export class ClientService {

  constructor(private appointmentHttpService: AppointmentHttpService,
              private clientHttpService: ClientHttpService) { }

  findAll() {
    return this.clientHttpService.findAll().toPromise();
  }

  appointmentsByClient(client: Client) {
    return this.appointmentHttpService.findByClient(client.documentNumber).toPromise();
  }

  delete(client: Client) {
    return this.clientHttpService.delete(client.id).toPromise();
  }
}
