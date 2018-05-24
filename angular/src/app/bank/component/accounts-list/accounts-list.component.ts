import { Component } from '@angular/core';
import { Account } from '../../model/account';
import { BankService } from '../../service/bank.service';

@Component({
  selector: 'app-accounts-list',
  templateUrl: './accounts-list.component.html',
  styleUrls: ['./accounts-list.component.css']
})
export class AccountsListComponent {

  accounts: Account[] = [];

  constructor(private bankService: BankService) {
    this.reload();
  }

  createAccount() {
    this.bankService.createAccount()
      .subscribe(() => this.reload())
  }

  private reload() {
    this.bankService.getAccounts()
      .subscribe((resultPage) => this.accounts = resultPage.data);
  }

}
