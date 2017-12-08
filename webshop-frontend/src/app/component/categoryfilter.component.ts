import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import { Category } from '../model/category';

import { UserService } from '../service/user.service';
import {CategoryService} from "../service/category.service";

@Component({
  selector: 'categoryfilter',
  templateUrl: './categoryfilter.component.html'
})

export class CategoryFilterComponent implements OnInit {
    categories: Category[];
    selectedCategories: number[] = new Array<number>();

    @Output()
    onSelectedCategoriesChanged = new EventEmitter<number[]>();

    constructor(private categoryService: CategoryService) {}

    ngOnInit(): void {
      this.categoryService.getCategories().subscribe(
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


    onCategorySelected(event): void {
    console.log(event.target.value);
    console.log(event.target.checked);
    if (event.target.checked) {
      this.selectedCategories.push(event.target.value);
    } else {
      this.selectedCategories = this.selectedCategories.filter(x => x !== event.target.value);
    }
    this.onSelectedCategoriesChanged.emit(this.selectedCategories);
  }
}
