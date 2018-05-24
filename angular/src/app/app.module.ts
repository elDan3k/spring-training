import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BankModule } from './bank/bank.module';
import { routerModule } from './app.routing';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BankModule,
    routerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
