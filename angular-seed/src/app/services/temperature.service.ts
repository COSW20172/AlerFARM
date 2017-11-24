import { Injectable } from '@angular/core';
import { Temperature } from '../models/temperature';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";

@Injectable()
export class TemperatureService extends APIService{
  private resourceUrl = 'api/temperature';


      create(value:Number,value2:Number,value3:Number,value4:Number,value5:Number):Observable<Temperature>{
        return this.post(this.resourceUrl,new Temperature(value,value2,value3,value4,value5));

      }
      
      list(): Observable<Temperature[]> {
        return this.get(this.resourceUrl);
      }

      listPorId(): Observable<Temperature[]> {
        this.resourceUrl = 'api/temperatures/'+(sessionStorage.getItem("email"));
        return this.get(this.resourceUrl);
      }

}
