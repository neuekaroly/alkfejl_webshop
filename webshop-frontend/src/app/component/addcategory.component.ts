import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';
import { Category } from '../model/category';
import {CategoryService} from "../service/category.service";

@Component({
  selector: 'addcategory',
  templateUrl: './addcategory.component.html'
})

export class AddCategoryComponent {
    category = new Category();

    constructor(private categoryService: CategoryService) {}

    addCategory(): void {
      this.categoryService.addCategory(this.category).subscribe(
        result => console.log('Success: ', result),
        error => {
          console.log('Error: ', error.json().message);
        }
      );
    }

    onAboveEighteenChecked(event): void {
    console.log(event.target.checked);
    if (event.target.checked) {
      this.category.aboveEighteen = true;
    } else {
      this.category.aboveEighteen = false;
    }
    }
}
