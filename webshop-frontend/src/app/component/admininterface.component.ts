import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { GameService } from '../service/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'admininterface',
  templateUrl: './admininterface.component.html'
})

export class AdminInterfaceComponent {

  constructor(private backendService: UserService, private router: Router) {}

    goToAddGame(): void {
    this.router.navigate(['/addgame']);
  }

  goToAddCategory(): void {
    this.router.navigate(['/addcategory']);
  }

  goToAddDeveloper(): void {
    this.router.navigate(['/adddeveloper']);
  }

  goToManageUsers(): void {
    //Must be finished
  }
}
