import { NgModule } from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'appointments', pathMatch: 'full' },
  {
    path: 'appointments',
    loadChildren: './feature/components/appointment/appointment.module#AppointmentModule'
  },
  {
    path: 'clients',
    loadChildren: './feature/components/client/client.module#ClientModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
