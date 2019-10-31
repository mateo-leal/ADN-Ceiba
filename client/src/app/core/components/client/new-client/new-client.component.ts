import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from 'src/app/core/models/client/client';
import { ClientService } from 'src/app/core/services/client/client.service';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.sass']
})
export class NewClientComponent implements OnInit {

  clientFormControl = new FormControl();
  client = new Client();

  constructor(private router: Router, private route: ActivatedRoute,
              private clientService: ClientService) { }

  ngOnInit() {
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
    this.clientService.create(this.client);
  }
}
