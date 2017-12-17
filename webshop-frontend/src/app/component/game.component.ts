import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

import { Router } from '@angular/router';
import {Game} from "../model/game";
import {BasketItem} from "../model/basketitem";
import {GameService} from "../service/game.service";

@Component({
  selector: 'game',
  templateUrl: './game.component.html'
})
export class GameComponent implements OnInit {
  @Input()
  game: Game;

  @Output()
  deleteGameById = new EventEmitter<number>();

  constructor(private gameService: GameService, private userService: UserService) {}

  ngOnInit() {}

  addGameToBasket(): void {
    console.log("Try adding the game to the basket");
    let basketItem = new BasketItem(this.game.gameName,this.game.price,this.game.platform,1);
    this.userService.addGameToCart(basketItem);
  }

  deleteGame(): void {
    this.deleteGameById.emit(this.game.id);
    console.log(this.game.id);
  }
}
