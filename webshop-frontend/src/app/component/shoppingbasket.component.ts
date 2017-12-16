import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { GameService } from '../service/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'shoppingbasket',
  templateUrl: './shoppingbasket.component.html'
})

export class ShoppingBasketComponent {

  constructor(private backendService: UserService, private router: Router) {}
}
