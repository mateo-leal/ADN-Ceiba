import { NgModule } from '@angular/core';

import { AppointmentComponent } from './appointment.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { AppointmentRoutingModule } from './appointment-routing.module';
import { NewAppointmentComponent } from './new-appointment/new-appointment.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppointmentService } from './appointment.service';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';

@NgModule({
  imports: [
    AppointmentRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ],
  declarations: [AppointmentComponent, NewAppointmentComponent, AppointmentListComponent],
  providers: [ AppointmentService ],
  exports: [],
})
export class AppointmentModule { }

