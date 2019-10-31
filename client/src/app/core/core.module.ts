import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AppointmentService } from './services/appointment/appointment.service';
import { NewAppointmentComponent } from './components/appointment/new-appointment/new-appointment.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewClientComponent } from './components/client/new-client/new-client.component';



@NgModule({
  declarations: [
    AppointmentComponent,
    NewAppointmentComponent,
    NewClientComponent
  ],
  imports: [
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    SharedModule
  ],
  providers: [
    AppointmentService
  ]
})
export class CoreModule { }
