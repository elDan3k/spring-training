import { Route, RouterModule } from '@angular/router';
import { AccountsListComponent } from './component/accounts-list/accounts-list.component';
import { DispositionComponent } from './component/disposition/disposition.component';
import { SecurityGuard } from '../security/security.guard';
import {AccountComponent} from "./component/account/account.component";
import {AccountResolver} from "./account-resolver";

const routes: Route[] = [
  {
    path: 'bank/accounts',
    component: AccountsListComponent,
    canActivate: [SecurityGuard]
  },
  {
    path: 'bank/accounts/:number',
    component: AccountComponent,
    canActivate: [SecurityGuard],
    resolve: { account: AccountResolver }
  },
  {
    path: 'bank/disposition',
    component: DispositionComponent,
    canActivate: [SecurityGuard]
  }
];

export const routerModule = RouterModule.forChild(routes);
