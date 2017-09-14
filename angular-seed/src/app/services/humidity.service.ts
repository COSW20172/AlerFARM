import { Injectable } from '@angular/core';
import { Humidity } from '../models/humidity';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";

@Injectable()
export class HumidityService extends APIService{
  private resourceUrl = 'api/humidity';

  
      create(value:string,value2:Number,value3:string):Observable<Humidity>{
        return this.post(this.resourceUrl,new Humidity(value,value2,value3));

      }
      
      list(): Observable<Humidity[]> {
        return this.get(this.resourceUrl);
      }

}
