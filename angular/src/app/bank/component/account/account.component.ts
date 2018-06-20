import {Component, Inject, OnInit} from '@angular/core';
import {Account} from "../../model/account";
import {ActivatedRoute, Router} from "@angular/router";
import {BankService} from "../../service/bank.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent {

  account = new Account();

  constructor(private router: Router, private route: ActivatedRoute, @Inject('BankService') private bankService: BankService) {
    this.account = this.route.snapshot.data.account;
  }

  confirm() {
    this.bankService.updateAccount(this.account)
      .subscribe(() => this.router.navigateByUrl('bank/accounts'));
  }

  cancel() {
    this.router.navigateByUrl('bank/accounts');
  }

  delete() {
    this.bankService.deleteAccount(this.account.number)
      .subscribe(() => this.router.navigateByUrl('bank/accounts'));
  }

}
