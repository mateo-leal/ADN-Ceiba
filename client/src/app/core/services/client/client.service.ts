import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Client } from '../../models/client/client';

@Injectable()
export class ClientService {


  api = 'http://localhost:8080/clients';

  constructor(private httpClient: HttpClient) { }

  public find(id: number) {
    return this.httpClient.get<Client[]>(`${this.api}/${id}`);
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
