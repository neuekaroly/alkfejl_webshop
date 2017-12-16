import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './main.component.html'
})
export class MainComponent {

  constructor(private backendService: UserService, private router: Router) {}

   goToWebshop(): void {
     this.router.navigate(['/register']);
  }

   goToOrders(): void {
    //Need to be finished
  }

   goToShoppingBasket(): void {
    //Need to be finished
  }

}
