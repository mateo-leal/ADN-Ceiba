import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';

import { Client } from '@app/core/models/client';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.sass']
})
export class ClientListComponent {

  @Input() clients: Observable<Client[]>;
  @Output() delete = new EventEmitter<Client>();

  displayedColumns: string[] = ['name', 'documentNumber', 'actions'];

  constructor() { }

  emitDelete(client: Client) {
    this.delete.emit(client);
  }
}
