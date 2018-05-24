import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './component/menu/menu.component';
import { BankService } from './service/bank.service';
import { HttpClientModule } from '@angular/common/http';
import { Api } from './api';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  declarations: [
    MenuComponent
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
