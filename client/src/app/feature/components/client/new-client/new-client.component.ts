import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientHttpService } from 'src/app/core/services/client/client-http.service';
import { MatSnackBar } from '@angular/material';
import { Client } from 'src/app/core/models/client';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.sass']
})
export class NewClientComponent implements OnInit {

  clientForm: FormGroup;
  clientExists: boolean;

  constructor(private router: Router, private route: ActivatedRoute,
              private clientService: ClientHttpService,
              private formBuilder: FormBuilder,
              private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.loadForm();
  }

  loadForm() {
    this.clientForm = this.formBuilder.group({
      documentNumber: ['', [Validators.required, Validators.maxLength(20)]],
      fullName: ['', [Validators.required, Validators.maxLength(30),
      Validators.pattern(/[a-zA-Z-]+\s[a-zA-Z-]+$/)]]
    });
    this.clientForm.get('documentNumber').valueChanges.subscribe(val => {
      this.clientService.findByDocumentNumber(val).subscribe(exists => {
        if (exists) {
          this.clientExists = true;
        } else {
          this.clientExists = false;
        }
      }, () => { });
    });
  }

  goBack() {
    this.route.queryParams.subscribe(params => {
      const redirectTo = params.redirectTo;
      if (redirectTo) {
        this.router.navigate([redirectTo]);
      } else {
        this.router.navigate(['/clients']);
      }
    });
  }

  save() {
    const client = new Client();
    client.documentNumber = this.clientForm.value.documentNumber;
    client.fullName = this.clientForm.value.fullName;
    this.clientService.create(client).subscribe(() => {
      this.snackbar.open('El cliente se registró correctamente', 'Cerrar', {
        duration: 3000,
      });
      this.route.queryParams.subscribe(params => {
        const redirectTo = params.redirectTo;
        if (redirectTo) {
          this.router.navigate([redirectTo], {
            queryParams: { clientDocumentNumber: client.documentNumber }
          });
        } else {
          this.router.navigate(['/clients']);
        }
      });
    }, () => {
      this.snackbar.open('Ocurrió un error almacenando el cliente', 'Cerrar', {
        duration: 10000,
      });
    });
  }
}
