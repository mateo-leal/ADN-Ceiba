import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './layout/header/header.component';
import { NavigationComponent } from './layout/navigation/navigation.component';
import { MaterialModule } from './material/material.module';
import { RouterModule } from '@angular/router';
import { ConfirmDeleteDialogComponent } from './components/confirm-delete-dialog/confirm-delete-dialog.component';



@NgModule({
  declarations: [
    HeaderComponent,
    NavigationComponent,
    ConfirmDeleteDialogComponent
  ],
  entryComponents: [ConfirmDeleteDialogComponent],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ],
  exports: [
    ConfirmDeleteDialogComponent,
    MaterialModule,
    HeaderComponent]
})
export class SharedModule { }
