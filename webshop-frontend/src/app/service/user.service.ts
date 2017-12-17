import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';

import { User } from '../model/user';
import { BasketItem } from '../model/basketitem';

@Injectable()
export class UserService {
    userloggedin: string = '9f57cd1c-6655-4a3c-9974-b020e429933d';

    basketItems: BasketItem[];

    constructor(private http: Http) {
       this.basketItems = [];
    }

    register(user: User): Observable<any> {
        console.log('Registering', user);
        return this.http.post('http://localhost:8080/users/register', user);
    }

    login(user: User): Observable<any> {
        console.log('Login', user);
        return this.http.post('http://localhost:8080/users/login', user);
    }

    addGameToCart(newBasketItem: BasketItem) {
        var isAdded: boolean;
        var i:number;
        isAdded = false;
        for(i = 0; i < this.basketItems.length; i++) {
            if(newBasketItem.gamename == this.basketItems[i].gamename && newBasketItem.platform == this.basketItems[i].platform) {
                isAdded = true;
                this.basketItems[i].quantity++;
                console.log("Is already have this game in the basket");
            }
        }
        if(!isAdded) {
            this.basketItems.push(newBasketItem);
        }

        this.addCart(JSON.stringify(this.basketItems)).subscribe(
            result => console.log("Sucess"),
            error => console.log(error.json().message)
        );
    }

    addCart(cart: string): Observable<any> {
      console.log('Add cart:',cart);
      let headers = new Headers();
      headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
      let options = new RequestOptions({headers: headers});
      return this.http.post('http://localhost:8080/users/cart/', cart, options);
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
