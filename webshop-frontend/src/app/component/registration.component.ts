import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../service/user.service';

import { User } from '../model/user';

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent {

  user: User = new User();

  selectedUserName: string;

  constructor(private backendService: UserService, private router: Router) {}

  register(): void {
    this.backendService.register(this.user).subscribe(
      result => {console.log('Success: ', result);
      this.goToLogin();},
      error => {
        console.log('Error: ', error.json().message);
      }
    );
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  selectname3(event): void {
    console.log(event);

    this.selectedUserName = event.target.value;
  }
}
