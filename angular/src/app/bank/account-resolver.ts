import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {BankService} from "./service/bank.service";
import {Account} from './model/account';
import {Inject} from "@angular/core";

export class AccountResolver implements Resolve<Account> {

  constructor(@Inject('BankService') private bankService: BankService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Account> {
    return this.bankService.getAccountByNumber(route.paramMap.get('number'));
  }

}
