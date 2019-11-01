import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

import { Client } from 'src/app/core/models/client/client';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from 'src/app/core/services/client/client.service';
import { Appointment } from 'src/app/core/models/appointment/appointment';

@Component({
  selector: 'app-new-appointment',
  templateUrl: './new-appointment.component.html',
  styleUrls: ['./new-appointment.component.sass']
})
export class NewAppointmentComponent implements OnInit {

  appointmentForm: FormGroup;
  minDate: Date;
  options: Client[];
  filteredOptions: Observable<Client[]>;

  constructor(private route: ActivatedRoute, private clientService: ClientService,
              private formBuilder: FormBuilder) {
    this.minDate = new Date();
    this.minDate.setDate(this.minDate.getDate() + 1);
  }

  ngOnInit() {
    this._initForm();
    this._getClients();
  }

  save() {
    const client = this.options.find(clientT => {
      return clientT.fullName === this.appointmentForm.value.client;
    });
    const appointment = new Appointment();
    appointment.client = client;
    appointment.appointmentDate = new Date(this.appointmentForm.value.appointmentDate);
    console.log(new Date().getTime());
    console.log(appointment);
  }

  private _filter(value: string): Client[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option =>
      option.fullName.toLowerCase().indexOf(filterValue) === 0
        || option.documentNumber.indexOf(filterValue) === 0);
  }

  private _initForm() {
    this.appointmentForm = this.formBuilder.group({
      client: ['', Validators.required],
      appointmentDate: [null, Validators.required],
      appointmentTime: [null, Validators.required]
    });
  }

  private _getClients() {
    this.clientService.findAll().subscribe(clients => {
      this.options = clients;
      this.route.queryParams.subscribe(params => {
        const clientDocumentNumber = params.clientDocumentNumber;
        if (clientDocumentNumber) {
          this.appointmentForm.get('client').setValue(this.options.find(client => {
            return client.documentNumber === clientDocumentNumber;
          }).fullName);
        }
      });
      this.filteredOptions = this.appointmentForm.get('client').valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
    });
  }
}
