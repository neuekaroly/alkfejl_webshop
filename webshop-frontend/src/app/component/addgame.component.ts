import { Component, Input, OnInit } from '@angular/core';

import { GameService } from '../service/game.service';
import { Game } from '../model/Game';

@Component({
  selector: 'addgame',
  templateUrl: './addgame.component.html'
})

export class AddGameComponent {

    game: Game = new Game();
    categoryIds: number[];

    constructor(private gameService: GameService) {}

    onSelectedCategoriesChanged(categoryIds: number[]) {
      console.log(categoryIds);
      categoryIds = categoryIds;
    }

    encodeAndSetCover(file) {
      const reader: FileReader = new FileReader();
      reader.readAsDataURL(file);
      reader.onloadend = () => {
        this.game.picture = reader.result;
      };
    }

    addGame(): void {
      this.game.categories = this.categoryIds;
      this.game.developerId = 2;
      this.gameService.addGame(this.game).subscribe(
        result => console.log('Success: ', result),
        error => {
          console.log('Error: ', error.json().message);
        }
      );
    }
}
