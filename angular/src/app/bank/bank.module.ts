import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './component/menu/menu.component';
import { BankService } from './service/bank.service';
import { HttpClientModule } from '@angular/common/http';
import { Api } from './api';
import { AccountsListComponent } from './component/accounts-list/accounts-list.component';
import { FormsModule } from '@angular/forms';
import { DispositionComponent } from './component/disposition/disposition.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  declarations: [
    MenuComponent,
    AccountsListComponent,
    DispositionComponent
  ],
  providers: [
    BankService,
    Api
  ],
  exports: [
    MenuComponent
  ]
})
export class BankModule { }
