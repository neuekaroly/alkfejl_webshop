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
    this.gameService.searchByGameName('pubg').subscribe(
      result => this.games = result.json().items,
      error => console.log(error)
    );
  }

}