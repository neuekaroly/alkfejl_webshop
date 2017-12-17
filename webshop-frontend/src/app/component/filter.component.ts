import {UserService} from "../service/user.service";
import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Filter } from "../model/filter";

@Component({
  selector: 'filter',
  templateUrl: './filter.component.html',
})
export class FilterComponent {

  filter: Filter = new Filter();

  @Output()
  onSearchByNameTag = new EventEmitter<string>();
  @Output()
  startSearchByNameTag = new EventEmitter<Filter>();

  constructor() {}

  showfilter() {
    console.log(this.filter.priceTag);
    console.log(this.filter.searchTag);
    console.log(this.filter.platforms);
  }
}
