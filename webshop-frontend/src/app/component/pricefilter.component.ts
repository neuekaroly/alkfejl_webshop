import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';
import {Filter} from "../model/filter";

@Component({
  selector: 'pricefilter',
  templateUrl: './pricefilter.component.html',
  styleUrls: ['./pricefilter.component.css']
})

export class PriceFilterComponent {
    value: any;

    @Input()
    filter: Filter;

    constructor() {
        this.value = 10000;
    }

  getValue (event) {
    this.value = event.target.value;
    this.filter.priceTag = Number(this.value);
  }
}
