import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentService } from './services/appointment/appointment.service';
import { ClientService } from './services/client/client.service';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './layout/header/header.component';
import { NavigationComponent } from './layout/navigation/navigation.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    HeaderComponent,
    NavigationComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    SharedModule
  ],
  providers: [
    AppointmentService,
    ClientService
  ],
  exports: [ HeaderComponent ]
})
export class CoreModule { }
