import {environment} from "../../environments/environment";

export class Api {

  accounts = `${environment.baseUrl}/accounts`;
  dispositions = `${environment.baseUrl}/dispositions`;

  oauthServer = `${environment.baseUrl}/oauth/token`;
  users = `${environment.baseUrl}/users`;
  activeUser = `${this.users}/active`;

}
