import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';

@Component({
  selector: 'platformfilter',
  templateUrl: './platformfilter.component.html'
})

export class CategoryFilterComponent {
    platforms: string[];

    constructor(private backendService: BackendService) {}

    getPlatforms(): void {
    this.backendService.getPlatforms().subscribe(
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