import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentHttpService } from './services/appointment/appointment-http.service';
import { ClientHttpService } from './services/client/client-http.service';
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
    AppointmentHttpService,
    ClientHttpService
  ],
  exports: [ HeaderComponent ]
})
export class CoreModule { }
