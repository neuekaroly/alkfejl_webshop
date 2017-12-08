import { Component, Input, OnInit } from '@angular/core';

import { DeveloperService } from '../service/developer.service';
import { Developer } from '../model/developer';

@Component({
  selector: 'adddeveloper',
  templateUrl: './adddeveloper.component.html'
})

export class AddDeveloperComponent {
    developer = new Developer();

    constructor(private developerService: DeveloperService) {}

    addDeveloper(): void {
      this.developerService.addDeveloper(this.developer).subscribe(
        result => console.log('Success: ', result),
        error => {
          console.log(this.developer);
          console.log('Error: ', error.json().message);
        }
      );
    }
}
