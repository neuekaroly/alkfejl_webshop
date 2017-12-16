import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './component/app.component';
import { RegistrationComponent } from './component/registration.component';
import { LoginComponent } from './component/login.component';
import { CategoryFilterComponent } from './component/categoryfilter.component';
import { PlatformFilterComponent } from './component/platformfilter.component';
import { PriceFilterComponent } from './component/pricefilter.component';
import { SearchComponent } from './component/search.component';
import { AddGameComponent } from './component/addgame.component';
import { AddCategoryComponent } from './component/addcategory.component';
import { AddDeveloperComponent } from './component/adddeveloper.component';
import { AdminInterfaceComponent } from './component/admininterface.component';

import { UserService } from './service/user.service';
import {DeveloperService} from "./service/developer.service";
import {GameService} from "./service/game.service";
import {CategoryService} from "./service/category.service";
import {PlatformService} from "./service/platform.service";
import {GameComponent} from "./component/game.component";

const routes: Routes = [
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'categoryfilter', component: CategoryFilterComponent },
  { path: 'platformfilter', component: PlatformFilterComponent },
  { path: 'pricefilter', component: PriceFilterComponent },
  { path: 'search', component: SearchComponent },
  { path: 'addgame', component: AddGameComponent },
  { path: '', redirectTo: '/register', pathMatch: 'full'},
  { path: 'addcategory', component: AddCategoryComponent},
  { path: 'adddeveloper', component: AddDeveloperComponent},
<<<<<<< HEAD
  { path: 'game', component: GameComponent}
=======
  { path: 'admininterface', component: AdminInterfaceComponent}
>>>>>>> db8c3d6bdbf885fc5f9cdbd71b99cabf2e16350a
]

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    CategoryFilterComponent,
    PlatformFilterComponent,
    PriceFilterComponent,
    SearchComponent,
    AddGameComponent,
    AddCategoryComponent,
    AddDeveloperComponent,
<<<<<<< HEAD
    GameComponent
=======
    AdminInterfaceComponent
>>>>>>> db8c3d6bdbf885fc5f9cdbd71b99cabf2e16350a
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [UserService, DeveloperService, CategoryService, GameService, PlatformService],
  bootstrap: [AppComponent]
})
export class AppModule { }
