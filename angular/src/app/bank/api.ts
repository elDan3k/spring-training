import {environment} from "../../environments/environment";

export class Api {

  accounts = `${environment.baseUrl}${environment.apiVersion}/accounts`;
  dispositions = `${environment.baseUrl}${environment.apiVersion}/dispositions`;

  oauthServer = `${environment.baseUrl}/oauth/token`;
  users = `${environment.baseUrl}${environment.apiVersion}/users`;
  activeUser = `${this.users}${environment.apiVersion}/active`;

}
