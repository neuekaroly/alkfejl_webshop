import { Component, Input, OnInit } from '@angular/core';

import { Game } from '../model/game'
import {GameService} from "../service/game.service";
import {Filter} from "../model/filter";
import {UserService} from "../service/user.service";
import {CategoryService} from "../service/category.service";

@Component({
  selector: 'store',
  templateUrl: './store.component.html'
})

export class StoreComponent implements OnInit {

  constructor(private gameService: GameService, private userService: UserService, private categoryService: CategoryService) {}

  games: Array<Game>;

  ngOnInit() {
    this.getAll();
    this.userService.getBasket();
    console.log("Store component: ",this.userService.basketItems);
  }

  getAll() {
    this.gameService.getAllGames().subscribe(
      result => this.games = result.json().items,
      error => console.log(error)
    );
  }

  onSearchGameName(searchTag: string) {
    if (searchTag === '') {
      this.getAll();
    } else {
      this.gameService.searchByGameName(searchTag).subscribe(
        result => this.games = result.json().items,
        error => console.log(error)
      );
    }
  }

  onStartAdvancedSearch(filter: Filter) {
    this.gameService.advancedSearch(JSON.parse(JSON.stringify(filter))).subscribe(
      result => this.games = result.json().items,
      error => console.log(error)
    );
  }

  startDeleteGameById(id: number) {
    this.gameService.deleteGame(id).subscribe(
      result => {console.log('Delete successfull');
        this.getAll(); },
      error => console.log(error)
    );
  }

  deleteCategoryById(catId: number) {

  }

}
