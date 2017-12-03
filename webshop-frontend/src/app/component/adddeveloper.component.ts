import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';
import { Developer } from '../model/developer';

@Component({
  selector: 'adddeveloper',
  templateUrl: './adddeveloper.component.html'
})

export class AddDeveloperComponent {
    developer = new Developer();

    constructor(private backendService: BackendService) {}

    addDeveloper(): void {
      this.backendService.addDeveloper(this.developer).subscribe(
        result => console.log('Success: ', result),
        error => {
          console.log(this.developer);
          console.log('Error: ', error.json().message);
        }
      );
    }
}