import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import {UserService} from "./user.service";

@Injectable()
export class PlatformService {

  constructor(private http: Http, private userService: UserService) {}

  getPlatforms(): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8080/games/platforms',options);
  }
}
