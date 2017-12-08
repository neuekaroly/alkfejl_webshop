import { Component, Input, OnInit } from '@angular/core';

import { Game } from '../model/Game'
import {GameService} from "../service/game.service";

@Component({
  selector: 'search',
  templateUrl: './search.component.html'
})

export class SearchComponent {

    searchtag: string;
    searchresult: Game[];

    constructor(private gameService: GameService) {}

    search(): void {
    this.gameService.searchByGameName(this.searchtag).subscribe(
      result => {
         console.log('Success: ', result),
         this.searchresult = result.json().items;
      },
      error => {
        console.log('Error: ', error.json().message);
      }
    );
  }
}
