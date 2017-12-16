import { Component, Input, OnInit } from '@angular/core';

import {PlatformService} from "../service/platform.service";
import {Filter} from "../model/filter";

@Component({
  selector: 'platformfilter',
  templateUrl: './platformfilter.component.html'
})

export class PlatformFilterComponent implements OnInit{
    platforms: string[];

    @Input()
    filter: Filter;

    constructor(private platformService: PlatformService) {}

    ngOnInit(): void {
    this.platformService.getPlatforms().subscribe(
      result => {
         console.log('Success: ', result),
         this.platforms = result.json().items;
         console.log(this.platforms);
      },
      error => {
        console.log('Error: ', error.json().message);
      }
    );
  }
}
