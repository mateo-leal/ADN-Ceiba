import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialModule } from './material/material.module';
import { ConfirmDeleteDialogComponent } from './components/confirm-delete-dialog/confirm-delete-dialog.component';

@NgModule({
  declarations: [ ConfirmDeleteDialogComponent ],
  entryComponents: [ConfirmDeleteDialogComponent],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    ConfirmDeleteDialogComponent,
    MaterialModule
  ]
})
export class SharedModule { }
