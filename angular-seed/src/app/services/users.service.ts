import { Injectable } from '@angular/core';
import { APIService } from '../common/api.service';
import { AppConfiguration } from '../common/config/app-configuration.service';
import { AuthService } from '../common/auth.service';
import { Http } from '@angular/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/add/observable/of';
import { User } from '../models/User';

@Injectable()
export class UsersService extends APIService {
  private resourceUrl = 'user/items';
  constructor(
    public config: AppConfiguration,
    public authService: AuthService,
    public http: Http
  ) {
    super(config, authService, http);
  }

  login(email: string, password: string) {
    return this.post('user/login', { email, password }, { credentials: false }).map(loginResponse => {
      if (loginResponse) {
        this.authService.accessToken = loginResponse.accessToken;
      }
    });
  }

  create(email:string,password:string,name: string, idUser: Number, celular: string):Observable<User>{
    return this.post(this.resourceUrl,new User(email,password,name, idUser, celular));

  }
  
  list(): Observable<User[]> {
    return this.get(this.resourceUrl);
  }
  
}