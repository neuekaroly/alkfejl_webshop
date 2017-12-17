import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import { Category } from '../model/category';

import { UserService } from '../service/user.service';
import {CategoryService} from "../service/category.service";
import {Filter} from "../model/filter";

@Component({
  selector: 'categoryfilter',
  templateUrl: './categoryfilter.component.html'
})

export class CategoryFilterComponent implements OnInit {
    categories: Category[];
    checked: boolean;

    @Input()
    filter: Filter;

    @Input()
    selectedCategories: number[];

    constructor(private categoryService: CategoryService) {}

    ngOnInit(): void {
      this.categoryService.getCategories().subscribe(
        result => {
          console.log('Success: ', result),
            this.categories = result.json().items;
            this.categoryService.allCategoryId = [];
            for (let i = 0; i < this.categories.length; ++i) {
              this.categoryService.allCategoryId.push(this.categories[i].id);
            }
          console.log(this.categories);
        },
        error => {
          console.log('Error: ', error.json().message);
        }
      );
    }


    onCategorySelected(event): void {

      let activeSelectedCategories: Array<number>;
      if (this.selectedCategories != null) {
        activeSelectedCategories = this.selectedCategories;
      }
      else {
        activeSelectedCategories = this.filter.categories;
      }

      if (event.target.checked) {
        activeSelectedCategories.push(event.target.value);
      } else {
        const indexOfValueToBeDeleted = activeSelectedCategories.indexOf(event.target.value);
        activeSelectedCategories.splice(indexOfValueToBeDeleted, 1);
      }
    }

    onAboveEighteenChecked(event) {
      if (event.target.checked) {
        this.checked = true;
      } else {
        this.checked = false;
      }
    }
}
