import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from 'src/app/core/models/appointment';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.sass']
})
export class AppointmentListComponent {

  @Input() appointments: Observable<Appointment[]>;
  @Output() delete = new EventEmitter<Appointment>();

  displayedColumns: string[] = ['client', 'appointmentDate', 'createdAt', 'price', 'actions'];

  constructor() { }

  emitDelete(appointment: Appointment) {
    this.delete.emit(appointment);
  }
}
