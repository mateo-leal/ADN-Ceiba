import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ClientComponent } from './client.component';
import { SharedModule } from '@app/shared/shared.module';
import { ClientRoutingModule } from './client-routing.module';
import { NewClientComponent } from './new-client/new-client.component';
import { ClientListComponent } from './client-list/client-list.component';

@NgModule({
  imports: [
    ClientRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ],
  exports: [],
  declarations: [ NewClientComponent, ClientComponent, ClientListComponent ],
  providers: [],
})
export class ClientModule { }
