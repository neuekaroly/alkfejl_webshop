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
    selectedPlatforms: number[];

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

  onPlatformSelected(event): void {

    let activeSelectedPlatforms: Array<number>;
    if (this.selectedPlatforms != null) {
      activeSelectedPlatforms = this.selectedPlatforms;
    }
    else {
      activeSelectedPlatforms = this.filter.categories;
    }

    if (event.target.checked) {
      activeSelectedPlatforms.push(event.target.value);
    } else {
      const indexOfValueToBeDeleted = activeSelectedPlatforms.indexOf(event.target.value);
      activeSelectedPlatforms.splice(indexOfValueToBeDeleted, 1);
    }
  }
}
