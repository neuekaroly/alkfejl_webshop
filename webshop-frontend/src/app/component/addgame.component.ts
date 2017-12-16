import { Component, Input, OnInit } from '@angular/core';
import { GameService } from '../service/game.service';
import { Game } from '../model/game';

import { Router } from '@angular/router';

@Component({
  selector: 'addgame',
  templateUrl: './addgame.component.html'
})

export class AddGameComponent {

    game: Game = new Game();
    categoryIds: Array<number> = [];

    constructor(private gameService: GameService) {}

    onSelectedCategoriesChanged(categoryIds: number[]) {
      console.log(categoryIds);
      this.categoryIds = categoryIds;
    }

    encodeAndSetCover(file) {
      const reader: FileReader = new FileReader();
      reader.readAsDataURL(file);
      reader.onloadend = () => {
        this.game.picture = reader.result;
      };
    }

    addGame(): void {
      this.game.categoryIds = this.categoryIds;
      this.gameService.addGame(this.game).subscribe(
        result => console.log('Success: ', result),
        error => {
          console.log('Error: ', error.json().message);
        }
      );
    }
}
