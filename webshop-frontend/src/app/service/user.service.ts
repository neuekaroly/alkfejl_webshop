import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';

import { User } from '../model/user';

@Injectable()
export class UserService {

    userloggedin: string = 'f85a5cff-2228-4e2a-bd60-a2237e357adc';

    constructor(private http: Http) {}

    register(user: User): Observable<any> {
        console.log('Registering', user);
        return this.http.post('http://localhost:8080/users/register', user);
    }

    login(user: User): Observable<any> {
        console.log('Login', user);
        return this.http.post('http://localhost:8080/users/login', user);
    }

    addCart(cart: string): Observable<any> {
      console.log('Add cart:', cart);
      let headers = new Headers();
      headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
      let options = new RequestOptions({headers: headers});
      return this.http.post('http://localhost:8080/users/login', cart, options)
    }

    getCart(): Observable<any> {
      console.log('Get cart');
      let headers = new Headers();
      headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
      let options = new RequestOptions({headers: headers});
      return this.http.post('http://localhost:8080/users/login', options);
    }

    deleteUser(userId: number): Observable<any> {
      console.log('Delete user', userId);
      let headers = new Headers();
      headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
      let options = new RequestOptions({headers: headers});
      return this.http.delete('http://localhost:8080/users/' + userId, options);
    }
}
