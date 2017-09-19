import { Component, OnInit } from '@angular/core';
import { TemperatureService } from '../../services/temperature.service';
import { Temperature } from '../../models/temperature';

@Component({
  selector: 'app-temperature-list-page',
  templateUrl: './temperature-list-page.component.html',
  styleUrls: ['./temperature-list-page.component.css']
})
export class TemperatureListPageComponent implements OnInit {
  private temperatures: Temperature[] = [];
  constructor(public temperatureService: TemperatureService) {

  }


  ngOnInit() {
    this.temperatureService.list().subscribe(temperatureResponse => {
      this.temperatures = temperatureResponse;
    })
  }

}
