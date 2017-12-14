import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { UserService } from "./user.service";
import { Order } from "../model/order";

@Injectable()
export class OrderService {

  constructor(private http: Http, private userService: UserService) {}

  addNewOrder(order: Order): Observable<any> {
    console.log('Add new order');
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/orders', order, options);
  }

  deleteOrder(orderId: number): Observable<any> {
    console.log('Add new order');
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/orders/' + orderId, options);
  }
}
