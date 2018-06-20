import {Component, Inject} from '@angular/core';
import { Account } from '../../model/account';
import { BankService } from '../../service/bank.service';
import {ResultPage} from "../../model/result-page";
import {Router} from "@angular/router";

@Component({
  selector: 'app-accounts-list',
  templateUrl: './accounts-list.component.html',
  styleUrls: ['./accounts-list.component.css']
})
export class AccountsListComponent {

  page = new ResultPage();

  constructor(@Inject('BankService') private bankService: BankService, private router: Router) {
    this.load(0);
  }

  createAccount() {
    this.bankService.createAccount()
      .subscribe(() => this.load(0));
  }

  private load(pageNumber: number) {
    this.bankService.getAccounts(pageNumber, 5)
      .subscribe((resultPage) => this.page = resultPage);
  }

  next() {
    this.load(this.page.pageNumber + 1);
  }

  previous() {
    this.load(this.page.pageNumber - 1);
  }

  edit(account: Account) {
    this.router.navigateByUrl(`bank/accounts/${account.number}`);
  }

}
