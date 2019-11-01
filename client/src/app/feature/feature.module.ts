import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    SharedModule,
    CommonModule
  ],
  exports: [ FeatureModule ]
})
export class FeatureModule { }
