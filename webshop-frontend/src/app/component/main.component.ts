import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {RoutingService, SHOPPINGBASKET, STORE} from '../service/routing.service';

@Component({
  selector: 'app-root',
  templateUrl: './main.component.html'
})
export class MainComponent {

  constructor(private backendService: UserService, private router: Router) {}

  SHOPPINGBASKET = SHOPPINGBASKET;
  STORE = STORE;

}
