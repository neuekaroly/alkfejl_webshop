import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';

@Component({
  selector: 'pricefilter',
  templateUrl: './pricefilter.component.html',
  styleUrls: ['./pricefilter.component.css']
})

export class PriceFilterComponent {
    value: any;

    constructor(private backendService: BackendService) {
        this.value = 5000;
    }

  getValue (event) {
    this.value = event.target.value;
    //console.log(this.value);
  }
}