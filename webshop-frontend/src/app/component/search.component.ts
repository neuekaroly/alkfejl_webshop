import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

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

    @Output()
    startSearchByNameTag = new EventEmitter<string>();

    constructor(private gameService: GameService) {}

    changedSearchTag() {
      this.filter.searchTag = this.searchtag;
    }

    searchByNameTag() {
      this.startSearchByNameTag.emit(this.searchtag);
    }
}
