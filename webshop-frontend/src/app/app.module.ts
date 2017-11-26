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

import { BackendService } from './service/backend.service';

const routes: Routes = [
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'categoryfilter', component: CategoryFilterComponent },
  { path: 'platformfilter', component: PlatformFilterComponent },
  { path: 'pricefilter', component: PriceFilterComponent },
  { path: 'search', component: SearchComponent },
  { path: 'addgame', component: AddGameComponent },
  { path: '', redirectTo: '/register', pathMatch: 'full'},
  { path: 'addcategory', component: AddCategoryComponent}
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
    AddCategoryComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [BackendService],
  bootstrap: [AppComponent]
})
export class AppModule { }
