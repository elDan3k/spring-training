import { Component, OnInit } from '@angular/core';
import {Account} from "../../model/account";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent {

  account = new Account();

  constructor(private route: ActivatedRoute) {
    this.account = this.route.snapshot.data.account;
  }

  confirm() {

  }

  cancel() {

  }

}
