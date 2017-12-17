import { Component, Input, OnInit } from '@angular/core';

import { Game } from '../model/game'
import {GameService} from "../service/game.service";

@Component({
  selector: 'store',
  templateUrl: './store.component.html'
})

export class StoreComponent implements OnInit {

  constructor(private gameService: GameService) {}

  games: Array<Game>;

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.gameService.getAllGames().subscribe(
      result => this.games = result.json().items,
      error => console.log(error)
    );
  }

  onSearchGameName(searchTag: string) {
    if(searchTag == '') {
      this.getAll();
    } else {
      this.gameService.searchByGameName(searchTag).subscribe(
        result => this.games = result.json().items,
        error => console.log(error)
      );
    }
  }

}
