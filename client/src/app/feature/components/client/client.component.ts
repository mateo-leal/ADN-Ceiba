import { Component, OnInit } from '@angular/core';
import { MatDialog, MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';

import { Client } from '@app/core/models/client';
import { ClientService } from './client.service';
import { ConfirmDeleteDialogComponent } from '@app/shared/components/confirm-delete-dialog/confirm-delete-dialog.component';
import { Appointment } from '@app/core/models/appointment';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.sass']
})
export class ClientComponent implements OnInit {

  clients: Client[];
  displayedColumns: string[] = ['name', 'documentNumber', 'actions'];

  constructor(private clientService: ClientService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) { }

  ngOnInit() {
    this._findAllClients();
  }

  onDelete(client: Client) {
    this._confirmElimination(
      `¿Estás seguro que deseas eliminar al cliente ${client.fullName}?`)
      .subscribe(confirm => {
        if (confirm) {
          this.clientService.appointmentsByClient(client)
            .then(appointments => {
              if (!appointments) {
                this.clientService.delete(client)
                  .then(() => {
                    this._throwMessage('Se eliminó el cliente correctamente');
                    this._findAllClients();
                  }).catch(() => this._throwMessage('Ocurrió un error eliminando el cliente'));
              } else {
                this._throwMessage('El cliente tiene citas registradas');
              }
            }).catch(() => this._throwMessage('Ocurrió un error consultando las citas del cliente'));
        }
      });
  }

  private _findAllClients() {
    this.clientService.findAll()
      .then(clients => this.clients = clients)
      .catch(() => this._throwMessage('Ocurrió un error consultando los clientes'));
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
