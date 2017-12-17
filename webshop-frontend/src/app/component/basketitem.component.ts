import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

import { Router } from '@angular/router';
import {Game} from "../model/game";
import {BasketItem} from "../model/basketitem";
import {GameService} from "../service/game.service";

@Component({
  selector: 'shopitem',
  templateUrl: './shopitem.component.html'
})
export class BasketItemComponent implements OnInit {
  @Input()
  basketitem: BasketItem;

  constructor(private gameService: GameService, private userService: UserService) {}

  ngOnInit() {}
}
