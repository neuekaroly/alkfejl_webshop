import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';
import { Game } from '../model/Game' 

@Component({
  selector: 'search',
  templateUrl: './search.component.html'
})

export class SearchComponent {
    
    searchtag: string;
    searchresult: Game[];

    constructor(private backendService: BackendService) {}

    search(): void {
    this.backendService.searchByGameName(this.searchtag).subscribe(
      result => {
         console.log('Success: ', result),
         this.searchresult = result.json().items;
      },
      error => {
        console.log('Error: ', error.json().message);
      }
    );
  }
}