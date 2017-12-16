import { Component, Input, OnInit } from '@angular/core';

import { Game } from '../model/Game'
import {GameService} from "../service/game.service";
import {Filter} from "../model/filter";

@Component({
  selector: 'search',
  templateUrl: './search.component.html'
})

export class SearchComponent {

    searchtag: string;

    @Input()
    filter: Filter;

    constructor(private gameService: GameService) {}

    changedSearchTag() {
      this.filter.searchTag = this.searchtag;
    }
}
