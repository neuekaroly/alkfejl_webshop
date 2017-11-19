import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';

import { User } from '../model/user';
import {Game} from "../model/game";

@Injectable()
export class BackendService {

    userloggedin: string;

    constructor(private http: Http) {}

    register(user: User): Observable<any> {
        console.log('Registering', user);
        return this.http.post('http://localhost:8080/users/register', user);
    }

    login(user: User): Observable<any> {
        console.log('Login', user);
        return this.http.post('http://localhost:8080/users/login', user);
    }

    getCategories(): Observable<any> {
         let headers = new Headers();
         headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
         let options = new RequestOptions({headers: headers});
        return this.http.get('http://localhost:8080/categories',options);
    }

    getPlatforms(): Observable<any> {
         let headers = new Headers();
         headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
         let options = new RequestOptions({headers: headers});
        return this.http.get('http://localhost:8080/games/platforms',options);
    }

    searchByGameName(searchtag: string): Observable<any> {
         let headers = new Headers();
         headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
         let options = new RequestOptions({headers: headers});
        return this.http.get('http://localhost:8080/games/search/' + searchtag, options);
    }

    addGame(game: Game): Observable<any> {
        let headers = new Headers();
        headers.append('X-WEBSHOP-TOKEN', this.userloggedin);
        let options = new RequestOptions({headers: headers});
      return this.http.post('http://localhost:8080/games', game, options);
    }
}
