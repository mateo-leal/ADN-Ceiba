import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

import { Client } from 'src/app/core/models/client/client';

@Component({
  selector: 'app-new-appointment',
  templateUrl: './new-appointment.component.html',
  styleUrls: ['./new-appointment.component.sass']
})
export class NewAppointmentComponent implements OnInit {

  appointmentFormControl = new FormControl();
  minDate: Date;
  options: Client[] = [
    { id: 1, documentNumber: '1238938246', fullName: 'Mateo Leal' },
    { id: 2, documentNumber: '1234567890', fullName: 'John Doe' },
    { id: 2, documentNumber: '71790427', fullName: 'Jessie Pink' }
  ];
  filteredOptions: Observable<Client[]>;

  constructor() {
    this.minDate = new Date();
    this.minDate.setDate(this.minDate.getDate() + 1);
  }

  ngOnInit() {
    this.filteredOptions = this.appointmentFormControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value))
    );
  }

  private _filter(value: string): Client[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option =>
      option.fullName.toLowerCase().indexOf(filterValue) === 0
        || option.documentNumber.indexOf(filterValue) === 0);
  }
}
