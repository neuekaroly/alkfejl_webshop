import { Component, Input, OnInit } from '@angular/core';

import { BackendService } from '../service/backend.service';

import { User } from '../model/user';

import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  user: User = new User();

  constructor(private backendService: BackendService, private router: Router) {}

  login(): void {
    this.backendService.login(this.user).subscribe(
      result => {
         console.log('Success: ', result),
         this.backendService.userloggedin = result.json().token;
         console.log(this.backendService.userloggedin);
      },
      error => {
        console.log('Error: ', error.json().message);
        this.router.navigate(['/login']);
      }
    );
  }

  goToRegister(): void {
    this.router.navigate(['/register']);
  }
}
