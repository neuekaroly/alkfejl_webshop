import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

import {Router} from '@angular/router';
import {BasketItem} from "../model/basketitem";
import {GameService} from "../service/game.service";

@Component({
  selector: 'basketitem',
  templateUrl: './basketitem.component.html'
})
export class BasketItemComponent implements OnInit {
  @Input()
  basketitem: BasketItem;

  constructor(private gameService: GameService, private userService: UserService) {}

  ngOnInit() {}

  deleteGame() {
    const index = this.userService.basketItems.indexOf(this.basketitem);
    console.log(this.userService.basketItems);
    this.userService.basketItems.splice(index, 1);
    this.userService.writeCartToDataBase();
  }
}
