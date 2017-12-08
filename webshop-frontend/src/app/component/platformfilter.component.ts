import { Component, Input, OnInit } from '@angular/core';

import {PlatformService} from "../service/platform.service";

@Component({
  selector: 'platformfilter',
  templateUrl: './platformfilter.component.html'
})

export class PlatformFilterComponent {
    platforms: string[];

    constructor(private platformService: PlatformService) {}

    getPlatforms(): void {
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
