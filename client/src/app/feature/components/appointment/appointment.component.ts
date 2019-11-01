import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/core/models/appointment/appointment';
import { AppointmentService } from 'src/app/core/services/appointment/appointment.service';

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
