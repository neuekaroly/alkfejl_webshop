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
    selectedPlatforms: string[];

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

    let activeSelectedPlatforms: Array<string>;
    if (this.selectedPlatforms != null) {
      activeSelectedPlatforms = this.selectedPlatforms;
    }
    else {
      activeSelectedPlatforms = this.filter.platforms;
    }

    if (event.target.checked) {
      activeSelectedPlatforms.push(event.target.value);
    } else {
      const indexOfValueToBeDeleted = activeSelectedPlatforms.indexOf(event.target.value);
      activeSelectedPlatforms.splice(indexOfValueToBeDeleted, 1);
    }

    console.log(activeSelectedPlatforms);
    console.log(this.filter.platforms);
  }
}
