import {UserService} from "../service/user.service";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'order',
  templateUrl: './order.component.html'
})
export class OrderComponent {

  constructor(private userService: UserService, private router: Router) {}
}
