import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import "rxjs/add/operator/map";
import "rxjs/add/operator/mergeMap";
import "rxjs/add/operator/do";
import {Observable} from "rxjs/internal/Observable";
import {BehaviorSubject} from "rxjs/internal/BehaviorSubject";
import {Api} from "../../bank/api";

@Injectable()
export class  SecurityService {

  user: Observable<User>;

  private token = '';
  private tokenKey = 'token';
  private userKey = 'user';
  private userSubject = new BehaviorSubject<User>(null);

  constructor(private httpClient: HttpClient, private api: Api) {
    this.user = this.userSubject.asObservable();
    this.restoreSecurityContext();
  }

  getToken(): string {
    return this.token;
  }

  getUser(): User {
    return this.userSubject.value;
  }

  private restoreSecurityContext() {
    const token = sessionStorage.getItem(this.tokenKey);
    if (token) {
      this.setToken(token);
    }
    const user = sessionStorage.getItem(this.userKey);
    if (user) {
      this.userSubject.next(JSON.parse(user));
    }
  }

  private setToken(token: string) {
    this.token = token;
    sessionStorage.setItem(this.tokenKey, token);
  }

  private setUser(user: User) {
    sessionStorage.setItem(this.userKey, JSON.stringify(user));
    this.userSubject.next(user);
  }

  login(username: string, password: string): Observable<User> {
    const credentials = this.prepareCredentials(username, password);
    return this.retrieveToken(credentials)
      .do(token => this.setToken(token))
      .mergeMap(() => this.retrieveUser())
      .do(user => this.setUser(user))
  }

  logout() {
    sessionStorage.removeItem(this.tokenKey);
    sessionStorage.removeItem(this.userKey);
    this.userSubject.next(null);
  }

  private prepareCredentials(username: string, password: string): string {
    const payload = new URLSearchParams();
    payload.set('username', username);
    payload.set('password', password);
    payload.set('grant_type', 'password');
    payload.set('client_id', 'bank');
    return payload.toString();
  }

  private retrieveToken(credentials: string): Observable<string> {
    const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
    return this.httpClient.post(this.api.oauthServer, credentials, { headers })
      .map(json => json['access_token'])
  }

  private retrieveUser(): Observable<User> {
    return this.httpClient.get(this.api.activeUser)
      .map(json => new User(json));
  }

}
