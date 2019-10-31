import { Client } from '../client/client';

export class Appointment {
  id: number;
  appointmentDate: Date;
  createdAt: Date;
  client: Client;
}
