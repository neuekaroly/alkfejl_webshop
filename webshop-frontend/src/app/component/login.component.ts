import { Component, Input, OnInit } from '@angular/core';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  user: User = new User();

  constructor(private userService: UserService, private router: Router) {}

  login(): void {
    this.userService.login(this.user).subscribe(
      result => {
         console.log('Success: ', result),
         this.userService.userloggedin = result.json().token;
         if (result.json().role === 'ADMIN') {
           this.userService.isAdmin = true;
         } else {
           this.userService.isAdmin = false;
         }
         console.log(this.userService.userloggedin);
         console.log(this.userService.isAdmin);
        this.router.navigate(['/store']);
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
