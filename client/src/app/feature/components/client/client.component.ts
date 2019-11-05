import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/core/models/client/client';
import { ClientService } from 'src/app/core/services/client/client.service';
import { MatDialog, MatSnackBar } from '@angular/material';
import { ConfirmDeleteDialogComponent } from 'src/app/shared/components/confirm-delete-dialog/confirm-delete-dialog.component';
import { Observable } from 'rxjs';
import { AppointmentService } from 'src/app/core/services/appointment/appointment.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.sass']
})
export class ClientComponent implements OnInit {

  clients: Client[];
  displayedColumns: string[] = ['name', 'documentNumber', 'actions'];

  constructor(private appointmentService: AppointmentService,
              private clientService: ClientService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) { }

  ngOnInit() {
    this._findAllClients();
  }

  delete(client: Client) {
    this._confirmElimination(
      `¿Estás seguro que deseas eliminar al cliente ${client.fullName}?`)
      .subscribe(confirm => {
        if (confirm) {
          this.appointmentService.findByClient(client.documentNumber)
            .subscribe(appointments => {
              if (!appointments) {
                this.clientService.delete(client.id).subscribe(() => {
                  this.snackbar.open('Se eliminó el cliente correctamente', 'Cerrar', {
                    duration: 5000,
                  });
                  this._findAllClients();
                });
              } else {
                this.snackbar.open('El cliente tiene citas registradas', 'Cerrar', {
                  duration: 5000,
                });
              }
            });
        }
      });
  }

  _findAllClients() {
    this.clientService.findAll()
      .subscribe(clients => this.clients = clients);
  }

  _confirmElimination(text: string): Observable<boolean> {
    const dialogRef = this.dialog.open(ConfirmDeleteDialogComponent, {
      width: '450px',
      data: text
    });
    return dialogRef.afterClosed();
  }
}
