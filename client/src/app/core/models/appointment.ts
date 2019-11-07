import { Client } from './client';

export class Appointment {
  id: number;
  appointmentDate: Date;
  createdAt: Date;
  price: number;
  client: Client;
}
