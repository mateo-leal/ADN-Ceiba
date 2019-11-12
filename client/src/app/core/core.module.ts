import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppointmentHttpService } from './services/appointment/appointment-http.service';
import { ClientHttpService } from './services/client/client-http.service';
import { HeaderComponent } from './layout/header/header.component';
import { NavigationComponent } from './layout/navigation/navigation.component';
import { SharedModule } from '@app/shared/shared.module';



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
    AppointmentHttpService,
    ClientHttpService
  ],
  exports: [ HeaderComponent ]
})
export class CoreModule { }
