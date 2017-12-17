import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import {UserService} from "./user.service";
import {Category} from "../model/category";

@Injectable()
export class CategoryService {

  allCategoryId: Array<number>;

  constructor(private http: Http, private userService: UserService) {}

  getCategories(): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8080/categories', options);
  }

  addCategory(category: Category): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/categories', category, options);
  }
}
