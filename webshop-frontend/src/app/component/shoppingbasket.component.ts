import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { GameService } from '../service/game.service';
import { Router } from '@angular/router';
import {BasketItem} from "../model/basketitem";

@Component({
  selector: 'shoppingbasket',
  templateUrl: './shoppingbasket.component.html'
})

export class ShoppingBasketComponent {

  basketitems: BasketItem[];
  constructor(private userService: UserService, private router: Router) {
      this.basketitems = this.userService.basketItems;
  }
}
