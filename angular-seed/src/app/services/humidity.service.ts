import { Injectable } from '@angular/core';
import { Humidity } from '../models/humidity';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";

@Injectable()
export class HumidityService extends APIService{
  private resourceUrl = 'api/humidity';

  
      create(value:Number,value2:Number,value3:Number,value4:Number,value5:Number):Observable<Humidity>{
        return this.post(this.resourceUrl,new Humidity(value,value2,value3,value4,value5));

      }
      
      list(): Observable<Humidity[]> {
        return this.get(this.resourceUrl);
      }

}
