import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import {UserService} from "./user.service";
import {Game} from "../model/game";

@Injectable()
export class GameService {

  constructor(private http: Http, private userService: UserService) {}

  searchByGameName(searchtag: string): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8080/games/search/' + searchtag, options);
  }

  getAllGames(): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8080/games/', options);
  }

  addGame(game: Game): Observable<any> {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/games', game, options);
  }
}
