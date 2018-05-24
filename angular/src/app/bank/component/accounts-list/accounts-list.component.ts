import { Component, Input } from '@angular/core';
import { Account } from '../../model/account';

@Component({
  selector: 'app-accounts-list',
  templateUrl: './accounts-list.component.html',
  styleUrls: ['./accounts-list.component.css']
})
export class AccountsListComponent {

  @Input()
  accounts: Account[] = [];

}
