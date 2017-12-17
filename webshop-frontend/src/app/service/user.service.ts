import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';

import { User } from '../model/user';
import { BasketItem } from '../model/basketitem';

@Injectable()
export class UserService {
    userloggedin: string;
    isAdmin: boolean;

    basketItems: Array <BasketItem>;

    constructor(private http: Http) {
    }

    register(user: User): Observable<any> {
        console.log('Registering', user);
        return this.http.post('http://localhost:8080/users/register', user);
    }

    login(user: User): Observable<any> {
        console.log('Login', user);
        return this.http.post('http://localhost:8080/users/login', user);
    }

    logout() {
      this.userloggedin = '';
      this.isAdmin = false;
    }

    getBasket(): void {
               this.getCart().subscribe(
        result => {
                if(result.json() != null) {
                    this.basketItems = result.json();
                }
                else {
                    this.basketItems = [];
                }
                console.log("getBasket(): ",this.basketItems);
            },
        error => console.log(error)
       );
    }

    addGameToCart(newBasketItem: BasketItem) {
        let isAdded: boolean;
        let i: number;
        //this.getBasket();
        console.log("Before for: ", this.basketItems);
        isAdded = false;
        for(i = 0; i < this.basketItems.length; i++) {
            if(newBasketItem.gameid == this.basketItems[i].gameid) {
                isAdded = true;
                this.basketItems[i].quantity++;
                console.log("Is already have this game in the basket");
            }
        }
        console.log("After for: ", this.basketItems);
        if(!isAdded) {
            console.log(this.basketItems);
            this.basketItems.push(newBasketItem);
        }

        this.writeCartToDataBase();

    }

    writeCartToDataBase(): void {
        this.addCart(JSON.stringify(this.basketItems)).subscribe(
            result => console.log("Sucess"),
            error => console.log(error.json().message)
        );
    }

    addCart(cart: string): Observable<any> {
      console.log('Add cart:', cart);
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
      return this.http.get('http://localhost:8080/users/cart', options);
    }

    deleteUser(userId: number): Observable<any> {
      console.log('Delete user', userId);
      let headers = new Headers();
      headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
      let options = new RequestOptions({headers: headers});
      return this.http.delete('http://localhost:8080/users/' + userId, options);
    }
}
