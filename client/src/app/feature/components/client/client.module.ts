import { NgModule } from '@angular/core';
import { ClientRoutingModule } from './client-routing.module';
import { NewClientComponent } from './new-client/new-client.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  imports: [
    ClientRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ],
  exports: [],
  declarations: [ NewClientComponent ],
  providers: [],
})
export class ClientModule { }
