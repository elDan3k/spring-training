import { Route, RouterModule } from '@angular/router';
import { AccountsListComponent } from './component/accounts-list/accounts-list.component';
import { DispositionComponent } from './component/disposition/disposition.component';

const routes: Route[] = [
  {
    path: 'bank/accounts',
    component: AccountsListComponent
  },
  {
    path: 'bank/disposition',
    component: DispositionComponent
  },
];

export const routerModule = RouterModule.forChild(routes);
