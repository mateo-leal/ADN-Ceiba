import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CitasComponent } from './core/citas/citas.component';


const routes: Routes = [
  { path: 'citas', component: CitasComponent },
  { path: '', redirectTo: '/citas', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
