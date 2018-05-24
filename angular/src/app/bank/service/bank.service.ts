import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable}  from 'rxjs/internal/Observable';
import { Api } from '../api';
import { Account } from '../model/account';

@Injectable()
export class BankService {

  constructor(private httpClient: HttpClient, private api: Api) {
  }

  createAccount(): Observable<Account> {
    return this.httpClient.post<Account>(this.api.accounts, {});
  }

}
