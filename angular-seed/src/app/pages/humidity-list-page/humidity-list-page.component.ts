import { Component, OnInit } from '@angular/core';
import { HumidityService } from '../../services/humidity.service';
import { Humidity } from '../../models/humidity';

@Component({
  selector: 'app-humidity-list-page',
  templateUrl: './humidity-list-page.component.html',
  styleUrls: ['./humidity-list-page.component.css']
})
export class HumidityListPageComponent implements OnInit {
  private humiditys: Humidity[] = [];
  constructor(public HumidityService: HumidityService) {

  }


  ngOnInit() {
    this.HumidityService.listPorId().subscribe(humidityResponse => {
      this.humiditys = humidityResponse;
     console.log(this.humiditys)
    })
  }

}
