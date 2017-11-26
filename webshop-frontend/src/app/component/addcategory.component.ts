import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';
import { Category } from '../model/category';

@Component({
  selector: 'addcategory',
  templateUrl: './addcategory.component.html'
})

export class AddCategoryComponent {
    category = new Category();

    constructor(private backendService: BackendService) {}

    addCategory(): void {
      this.backendService.addCategory(this.category).subscribe(
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