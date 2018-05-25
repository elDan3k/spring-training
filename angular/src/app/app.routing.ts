import { Route, RouterModule } from "@angular/router";
import { AccountsListComponent } from './bank/component/accounts-list/accounts-list.component';
import { SecurityGuard } from './security/security.guard';

const routes: Route[] = [
  {
    path: '',
    component: AccountsListComponent,
    canActivate: [SecurityGuard]
  }
];

export const routerModule = RouterModule.forRoot(routes);
