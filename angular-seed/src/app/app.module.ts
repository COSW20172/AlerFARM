import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppConfiguration } from './common/config/app-configuration.service';
import { INITIAL_CONFIG } from './common/config/initial-config';

import { AppComponent } from './app.component';

import { HomePageComponent } from './pages/home-page/home-page.component';
import { TaskListPageComponent } from './pages/task-list-page/task-list-page.component';
import { TaskEditPageComponent } from './pages/task-edit-page/task-edit-page.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { UserListPageComponent } from './pages/user-list-page/user-list-page.component';
import { UserEditPageComponent } from './pages/user-edit-page/user-edit-page.component';
import { TemperatureListPageComponent } from './pages/temperature-list-page/temperature-list-page.component';
import { TemperatureEditPageComponent } from './pages/temperature-edit-page/temperature-edit-page.component';
import { HumidityListPageComponent } from './pages/humidity-list-page/humidity-list-page.component';
import { HumidityEditPageComponent } from './pages/humidity-edit-page/humidity-edit-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { TodoService } from './services/todo.service';
import { HttpModule } from '@angular/http';
import { SingInPageComponent } from './pages/sign-in/sing-in-page.component';
import { AuthService } from './common/auth.service';
import { AppDataService } from './common/app-data.service';
import { UsersService } from './services/users.service';
import { TemperatureService } from './services/temperature.service';
import { HumidityService } from './services/humidity.service';
const ROUTES = [
  { path: '', component: SingInPageComponent },
  { path: 'home', component: HomePageComponent },
  {
    path: 'tasks', component: TaskListPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'edit', component: TaskEditPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'users', component: UserListPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'user', component: UserEditPageComponent,
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
    TaskListPageComponent,
    TaskEditPageComponent,
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
    HttpModule
  ],
  providers: [
    {
      provide: INITIAL_CONFIG,
      useValue: {
        apiURL: 'http://localhost:8080'
      }
    },
    TodoService,
    AuthService,
    AppDataService,
    UsersService,
    TemperatureService,
    HumidityService,
    AppConfiguration],
  bootstrap: [AppComponent]
 })
 export class AppModule { }