import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppointmentComponent } from './appointment.component';
import { AppointmentRoutingModule } from './appointment-routing.module';
import { NewAppointmentComponent } from './new-appointment/new-appointment.component';
import { AppointmentService } from './appointment.service';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { SharedModule } from '@app/shared/shared.module';

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

