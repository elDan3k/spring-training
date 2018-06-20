import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {Api} from '../api';
import {Account} from '../model/account';
import {ResultPage} from "../model/result-page";
import {Disposition} from "../model/disposition";

@Injectable()
export class BankService {

  constructor(private httpClient: HttpClient, private api: Api) {
  }

  createAccount(): Observable<Account> {
    return this.httpClient.post<Account>(this.api.accounts, {});
  }

  getAccounts(pageNumber = 0, pageSize = 100): Observable<ResultPage<Account>> {
    const params = {pageNumber: `${pageNumber}`, pageSize: `${pageSize}`};
    return this.httpClient.get<ResultPage<Account>>(this.api.accounts, {params});
  }

  getAccountByNumber(number: string): Observable<Account> {
    return this.httpClient.get<Account>(`${this.api.accounts}/${number}`);
  }

  processDisposition(disposition: Disposition): Observable<void> {
    return this.httpClient.post<void>(this.api.dispositions, disposition);
  }

  updateAccount(account: Account): Observable<void> {
    return this.httpClient.put<void>(`${this.api.accounts}/${account.number}`, account);
  }

  deleteAccount(accountNumber: string): Observable<void> {
    return this.httpClient.delete<void>(`${this.api.accounts}/${accountNumber}`);
  }

}
