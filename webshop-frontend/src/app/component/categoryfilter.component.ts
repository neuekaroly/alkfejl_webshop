import { Component, Input, OnInit } from '@angular/core';

import { Category } from '../model/category';

import { BackendService } from '../service/backend.service';

@Component({
  selector: 'categoryfilter',
  templateUrl: './categoryfilter.component.html'
})

export class CategoryFilterComponent {
    categories: Category[];

    constructor(private backendService: BackendService) {}

    getCategories(): void {
    this.backendService.getcategories().subscribe(
      result => {
         console.log('Success: ', result),
         this.categories = result.json().items;
         console.log(this.categories);
      },
      error => {
        console.log('Error: ', error.json().message);
      }
    );
  }
}