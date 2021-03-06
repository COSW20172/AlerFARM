import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppConfiguration } from './common/config/app-configuration.service';
import { INITIAL_CONFIG } from './common/config/initial-config';

import { AppComponent } from './app.component';

import { HomePageComponent } from './pages/home-page/home-page.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { UserListPageComponent } from './pages/user-list-page/user-list-page.component';
import { UserEditPageComponent } from './pages/user-edit-page/user-edit-page.component';
import { TemperatureListPageComponent } from './pages/temperature-list-page/temperature-list-page.component';
import { TemperatureEditPageComponent } from './pages/temperature-edit-page/temperature-edit-page.component';
import { HumidityListPageComponent } from './pages/humidity-list-page/humidity-list-page.component';
import { HumidityEditPageComponent } from './pages/humidity-edit-page/humidity-edit-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HttpModule } from '@angular/http';
import { SingInPageComponent } from './pages/sign-in/sing-in-page.component';
import { AuthService } from './common/auth.service';
import { AppDataService } from './common/app-data.service';
import { UsersService } from './services/users.service';
import { TemperatureService } from './services/temperature.service';
import { HumidityService } from './services/humidity.service';
const ROUTES = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'sign', component: SingInPageComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'user', component: UserEditPageComponent},
  {
    path: 'users', component: UserListPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'temperatures', component: TemperatureListPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'temperature', component: TemperatureEditPageComponent,
    canActivate: [AuthService],
  },{
    path: 'humiditys', component: HumidityListPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'humidity', component: HumidityEditPageComponent,
    canActivate: [AuthService],
  },  {
        path: '**', component: PageNotFoundComponent
      },
  
]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    PageNotFoundComponent,
    SingInPageComponent,
    UserListPageComponent,
    UserEditPageComponent,
    TemperatureListPageComponent,
    TemperatureEditPageComponent,
    HumidityListPageComponent,
    HumidityEditPageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(ROUTES),
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule
  ],
  providers: [
    {
      provide: INITIAL_CONFIG,
      useValue: {
        apiURL: 'https://alertfarm.herokuapp.com'
      }
    },
    AuthService,
    AppDataService,
    UsersService,
    TemperatureService,
    HumidityService,
    AppConfiguration],
  bootstrap: [AppComponent]
 })
 export class AppModule { }
