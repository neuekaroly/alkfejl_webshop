import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import {UserService} from "./user.service";
import {Developer} from "../model/developer";

@Injectable()
export class DeveloperService {

  constructor(private http: Http, private userService: UserService) {}

  addDeveloper(developer: Developer): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/developers', developer, options);
  }

  getDevelopers(): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8080/developers', options);
  }
}
