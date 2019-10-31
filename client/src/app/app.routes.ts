import { Routes } from '@angular/router';
import { AppointmentComponent } from './core/components/appointment/appointment.component';
import { NewAppointmentComponent } from './core/components/appointment/new-appointment/new-appointment.component';
import { NewClientComponent } from './core/components/client/new-client/new-client.component';

export const AppRoutes: Routes = [
  { path: '', redirectTo: 'appointments', pathMatch: 'full' },
  { path: 'appointments', component: AppointmentComponent },
  { path: 'appointments/new', component: NewAppointmentComponent },
  { path: 'clients/new', component: NewClientComponent }
];
