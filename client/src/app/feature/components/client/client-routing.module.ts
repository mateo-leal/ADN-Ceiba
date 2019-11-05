import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientComponent } from './client.component';
import { NewClientComponent } from './new-client/new-client.component';

const routes: Routes = [
  { path: '', component: ClientComponent },
  { path: 'new', component: NewClientComponent }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class ClientRoutingModule { }
