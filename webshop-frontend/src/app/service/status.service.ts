import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { UserService } from "./user.service";
import { Status } from "../model/status";

@Injectable()
export class OrderService {

  constructor(private http: Http, private userService: UserService) {}

  changeOrderStatus(status: Status): Observable<any> {
    console.log('Changing order Status');
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/status/orderstatus', status, options);
  }

  changeShippingStatus(status: Status): Observable<any>  {
    console.log('Changing shipping Status');
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/status/shippingstatus', status, options);
  }
}
