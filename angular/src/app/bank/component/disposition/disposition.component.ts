import { Component } from '@angular/core';
import { Disposition } from '../../model/disposition';
import { BankService } from '../../service/bank.service';

@Component({
  selector: 'app-disposition',
  templateUrl: './disposition.component.html',
  styleUrls: ['./disposition.component.css']
})
export class DispositionComponent {

  disposition = new Disposition();

  constructor(private bankService: BankService) {
  }

  cancel() {
  }

  confirm() {
    this.bankService.processDisposition(this.disposition)
      .subscribe(() => console.log("Done"));
  }

}
