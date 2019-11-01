import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentService } from './services/appointment/appointment.service';
import { ClientService } from './services/client/client.service';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [ ],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [
    AppointmentService,
    ClientService
  ],
  exports: [ ]
})
export class CoreModule { }
