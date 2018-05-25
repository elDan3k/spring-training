import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {SecurityService} from "./security/service/security.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  username: string;

  constructor(private router: Router, private securityService:SecurityService) {
    securityService.user.subscribe(user => {
      this.username = user != null ? user.name : '';
    });
  }

  logout() {
    this.securityService.logout();
    this.router.navigateByUrl('login');
  }

}
