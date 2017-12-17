import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LOGIN, SHOPPINGBASKET, STORE} from '../service/routing.service';

@Component({
  selector: 'app-root',
  templateUrl: './main.component.html'
})
export class MainComponent {

  constructor(private userService: UserService) {}

  SHOPPINGBASKET = SHOPPINGBASKET;
  STORE = STORE;
  LOGIN = LOGIN;

  logout() {
    this.userService.logout();
  }
}
