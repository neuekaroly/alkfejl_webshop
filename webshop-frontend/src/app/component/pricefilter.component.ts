import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';

@Component({
  selector: 'pricefilter',
  templateUrl: './pricefilter.component.html',
  styleUrls: ['./pricefilter.component.css']
})

export class PriceFilterComponent {
    value: any;

    constructor(private backendService: UserService) {
        this.value = 5000;
    }

  getValue (event) {
    this.value = event.target.value;
    //console.log(this.value);
  }
}
