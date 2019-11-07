import {NgModule} from '@angular/core';
import {
  MatAutocompleteModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatDatepickerModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatNativeDateModule,
  MatSelectModule,
  MatSnackBarModule,
  MatTableModule,
  MatToolbarModule,
  MatTooltipModule
} from '@angular/material';

import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';

/**
 * NgModule that includes all Material modules.
 */
@NgModule({
  exports: [
    // Material
    MatAutocompleteModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatDatepickerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatNativeDateModule,
    MatSelectModule,
    MatSnackBarModule,
    MatTableModule,
    MatToolbarModule,
    MatTooltipModule,
    // custom
    NgxMaterialTimepickerModule
  ]
})
export class MaterialModule {}
