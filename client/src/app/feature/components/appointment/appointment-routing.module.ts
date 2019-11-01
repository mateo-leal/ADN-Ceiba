import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentComponent } from './appointment.component';
import { NewAppointmentComponent } from './new-appointment/new-appointment.component';

const routes: Routes = [
  { path: '', component: AppointmentComponent },
  { path: 'new', component: NewAppointmentComponent }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class AppointmentRoutingModule { }
