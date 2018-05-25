import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SecurityInterceptor } from './security/security.interceptor';
import { TokenInterceptor } from './security/token.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BankModule } from './bank/bank.module';
import { routerModule } from './app.routing';
import { SecurityModule } from './security/security.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BankModule,
    routerModule,
    SecurityModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: SecurityInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
