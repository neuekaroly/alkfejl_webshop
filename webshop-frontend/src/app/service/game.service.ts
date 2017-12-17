import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import {UserService} from "./user.service";
import {Game} from "../model/game";
import {Filter} from "../model/filter";
import {CategoryService} from "./category.service";

@Injectable()
export class GameService {

  constructor(private http: Http, private userService: UserService, private categoryService: CategoryService) {}

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

  advancedSearch(filter: Filter) {
    if (filter.searchTag === '') {
      filter.searchTag = '%';
    }
    if (filter.priceTag === -1) {
      filter.priceTag = 20000;
    }
    if (filter.categories.length === 0) {
      filter.categories = this.categoryService.allCategoryId;
    }
    if (filter.platforms.length === 0) {
      filter.platforms.push('PC');
      filter.platforms.push('PS4');
      filter.platforms.push('XBOXONE');
    }
    console.log(filter);

    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.patch('http://localhost:8080/games/advancedsearch', filter, options);
  }

  deleteGame(id: number) {
    let headers = new Headers();
    headers.append('X-WEBSHOP-TOKEN', this.userService.userloggedin);
    let options = new RequestOptions({headers: headers});
    return this.http.delete('http://localhost:8080/games/' + id, options);
  }
}
