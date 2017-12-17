import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {RoutingService, LOGIN, SHOPPINGBASKET, STORE, ADDGAME, ADDCATEGORY, ADDDEVELOPER} from '../service/routing.service';

@Component({
  selector: 'app-root',
  templateUrl: './main.component.html'
})
export class MainComponent {

  constructor(private userService: UserService, private router: Router) {}

  SHOPPINGBASKET = SHOPPINGBASKET;
  STORE = STORE;
  ADDGAME = ADDGAME;
  ADDCATEGORY = ADDCATEGORY;
  ADDDEVELOPER = ADDDEVELOPER;
  LOGIN = LOGIN;

  logout() {
    this.userService.logout();
  }
}
