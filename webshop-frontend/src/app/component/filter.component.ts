import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Filter } from "../model/filter";

@Component({
  selector: 'filter',
  templateUrl: './filter.component.html',
})
export class FilterComponent {

  filter: Filter = new Filter();

  constructor() {}

  showfilter() {
    console.log(this.filter.priceTag);
    console.log(this.filter.searchTag);
  }
}
