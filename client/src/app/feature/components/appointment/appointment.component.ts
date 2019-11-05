import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/core/models/appointment/appointment';
import { AppointmentService } from 'src/app/core/services/appointment/appointment.service';
import { ConfirmDeleteDialogComponent } from '../../../shared/components/confirm-delete-dialog/confirm-delete-dialog.component';
import { MatDialog, MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.sass']
})
export class AppointmentComponent implements OnInit {

  appointments: Appointment[];
  displayedColumns: string[] = ['client', 'appointmentDate', 'createdAt', 'actions'];

  constructor(private appointmentService: AppointmentService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) { }

  ngOnInit() {
    this._findAllAppointments();
  }

  delete(appointment: Appointment) {
    this._confirmElimination(
      `¿Estás seguro que deseas eliminar la cita de ${appointment.client.fullName}?`)
      .subscribe(confirm => {
        if (confirm) {
          this.appointmentService.delete(appointment.id).subscribe(() => {
            this.snackbar.open('Se eliminó la cita correctamente', 'Cerrar', {
              duration: 5000,
            });
            this._findAllAppointments();
          });
        }
      });
  }

  _findAllAppointments() {
    this.appointmentService.findAll()
      .subscribe(appointments => this.appointments = appointments);
  }

  _confirmElimination(text: string): Observable<boolean> {
    const dialogRef = this.dialog.open(ConfirmDeleteDialogComponent, {
      width: '450px',
      data: text
    });
    return dialogRef.afterClosed();
  }
}
