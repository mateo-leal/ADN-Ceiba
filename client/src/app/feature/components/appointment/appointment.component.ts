import { Component, OnInit } from '@angular/core';
import { MatDialog, MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';

import { Appointment } from 'src/app/core/models/appointment';
import { AppointmentService } from './appointment.service';
import { ConfirmDeleteDialogComponent } from '../../../shared/components/confirm-delete-dialog/confirm-delete-dialog.component';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.sass']
})
export class AppointmentComponent implements OnInit {

  appointments: Observable<Appointment[]>;

  constructor(private appointmentService: AppointmentService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) { }

  ngOnInit() { this._findAllAppointments(); }

  onDelete(appointment: Appointment) {
    this._confirmElimination(
      `¿Estás seguro que deseas eliminar la cita de ${appointment.client.fullName}?`)
      .subscribe(confirm => {
        if (confirm) {
          this.appointmentService.delete(appointment)
            .then(() => this._throwMessage('Se eliminó la cita correctamente'))
            .then(() => this._findAllAppointments())
            .catch(() => this._throwMessage('Error eliminando la cita'));
        }
      });
  }

  private _findAllAppointments(): void {
    this.appointments = this.appointmentService.findAll();
  }

  private _confirmElimination(text: string): Observable<boolean> {
    const dialogRef = this.dialog.open(ConfirmDeleteDialogComponent, {
      width: '450px',
      data: text
    });
    return dialogRef.afterClosed();
  }

  private _throwMessage(message: string): void {
    this.snackbar.open(message, 'Cerrar', {
      duration: 5000,
    });
  }
}
