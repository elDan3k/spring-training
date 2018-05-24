import { Component } from '@angular/core';
import { Disposition } from '../../model/disposition';
import { BankService } from '../../service/bank.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-disposition',
  templateUrl: './disposition.component.html',
  styleUrls: ['./disposition.component.css']
})
export class DispositionComponent {

  disposition = new Disposition();

  constructor(private bankService: BankService, private router: Router) {
  }

  showAccounts() {
    this.router.navigateByUrl('bank/accounts')
  }

  confirm() {
    this.bankService.processDisposition(this.disposition)
      .subscribe(() => this.showAccounts());
  }

}
