import { Component } from '@angular/core';
import { BankService } from '../../service/bank.service';
import {Account} from "../../model/account";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  showMessage = false;
  message = 'Operation status: success';

  accounts: Account[] = [];

  constructor(private bankService: BankService, ) {
  }

  createAccount() {
    this.bankService.createAccount()
      .subscribe(() => {
        this.showMessage = true
        this.hideMessage();
      });
  }

  showAccounts() {
    this.bankService.getAccounts()
      .subscribe((resultPage) => this.accounts = resultPage.data);
  }

  private hideMessage() {
    setTimeout(() => this.showMessage = false, 2000);
  }

}
