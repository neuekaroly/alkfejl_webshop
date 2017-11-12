import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { BackendService } from './service/backend.service';

import { User } from './model/user';

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {

  user: User = new User();

  userList: User[] = new Array<User>();

  selectedUserName: string;

  constructor(private backendService: BackendService, private router: Router) {}

  ngOnInit(): void {
    this.user.username = 'adasdsa';

    const names = ['name1', 'name2', 'name3'];
    for (const name of names) {
      const tempUser: User = new User();
      tempUser.username = name;
      this.userList.push(tempUser);
    }
  }

  register(): void {
    this.backendService.register(this.user).subscribe(
      result => console.log('Success: ', result),
      error => {
        console.log('Error: ', error.json().message);
        this.router.navigate(['/login']);
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
