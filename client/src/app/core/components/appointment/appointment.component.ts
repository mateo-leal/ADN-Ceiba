import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../../services/appointment/appointment.service';
import { Appointment } from '../../models/appointment/appointment';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.sass']
})
export class AppointmentComponent implements OnInit {

  appointments: Appointment[];
  displayedColumns: string[] = ['client', 'appointmentDate', 'createdAt'];

  constructor(private appointmentService: AppointmentService) { }

  ngOnInit() {
    this.appointmentService.findAll()
      .subscribe(appointments => this.appointments = appointments);
  }

}
