import { Injectable } from '@angular/core';
import { Temperature } from '../models/temperature';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";

@Injectable()
export class TemperatureService extends APIService{
  private resourceUrl = 'api/temperature';

  
      create(value:string,value2:Number,value3:string):Observable<Temperature>{
        return this.post(this.resourceUrl,new Temperature(value,value2,value3));

      }
      
      list(): Observable<Temperature[]> {
        return this.get(this.resourceUrl);
      }

}
