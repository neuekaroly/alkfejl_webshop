import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';

@Component({
  selector: 'search',
  templateUrl: './search.component.html'
})

export class SearchComponent {
    
    searchtag: string;

    constructor(private backendService: BackendService) {}

    search() {
        console.log(this.searchtag);
    }
}