import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private userService: UserService) {}

   goToWebshop(): void {
    //Need to be finished
  }

   goToOrders(): void {
    //Need to be finished
  }

   goToShoppingBasket(): void {
    //Need to be finished
  }

}
