import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '@env/environment';

import { Client } from '@app/core/models/client';

@Injectable()
export class ClientHttpService {

  api = `${environment.api}/clients`;

  constructor(private httpClient: HttpClient) { }

  public find(id: number) {
    return this.httpClient.get<Client[]>(`${this.api}/${id}`);
  }

  public findByDocumentNumber(documentNumber: string) {
    return this.httpClient.get<Client[]>(`${this.api}?documentNumber=${documentNumber}`);
  }

  public findAll() {
    return this.httpClient.get<Client[]>(this.api);
  }

  public create(client: Client) {
    return this.httpClient.post(this.api, client);
  }

  // public update(client: Client) {}

  public delete(id: number) {
    return this.httpClient.delete(`${this.api}/${id}`);
  }
}
