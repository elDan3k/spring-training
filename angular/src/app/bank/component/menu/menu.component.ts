import { Component } from '@angular/core';
import { BankService } from '../../service/bank.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  showMessage = false;
  message = 'Operation status: success';

  constructor(private bankService: BankService, ) {
  }

  createAccount() {
    this.bankService.createAccount()
      .subscribe(() => {
        this.showMessage = true
        this.hideMessage();
      });
  }

  private hideMessage() {
    setTimeout(() => this.showMessage = false, 2000);
  }

}
