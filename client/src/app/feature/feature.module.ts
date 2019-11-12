import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '@app/shared/shared.module';

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
  exports: [ ]
})
export class FeatureModule { }
