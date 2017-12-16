import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

import { Router } from '@angular/router';
import {Game} from "../model/game";
import {GameService} from "../service/game.service";

@Component({
  selector: 'game',
  templateUrl: './game.component.html'
})
export class GameComponent implements OnInit {
  @Input()
  game: Game;

  constructor(private gameService: GameService) {}

  ngOnInit() {

  }


}
