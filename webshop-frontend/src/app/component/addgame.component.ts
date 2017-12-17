import { Component, Input, OnInit } from '@angular/core';
import { GameService } from '../service/game.service';
import { Game } from '../model/game';

import { Router } from '@angular/router';
import {Developer} from "../model/developer";
import {DeveloperService} from "../service/developer.service";

@Component({
  selector: 'addgame',
  templateUrl: './addgame.component.html'
})

export class AddGameComponent implements OnInit{

    game: Game = new Game();
    categoryIds: Array<number> = [];
    developers: Developer[];

    constructor(private gameService: GameService, private developerService: DeveloperService) {}

    ngOnInit() {
      this.developerService.getDevelopers().subscribe(
        result => this.developers = result.json().items,
        error => console.log(error.json())
      );
    }

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
