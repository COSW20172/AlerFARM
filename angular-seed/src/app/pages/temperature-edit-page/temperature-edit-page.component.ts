import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { TemperatureService } from '../../services/temperature.service';

@Component({
  selector: 'app-temperature-edit-page',
  templateUrl: './temperature-edit-page.component.html',
  styleUrls: ['./temperature-edit-page.component.css'],
  
})
export class TemperatureEditPageComponent implements OnInit {
  temperaturaForm: FormGroup; 
  constructor(
    public temperatureService: TemperatureService,
    public formBuilder: FormBuilder,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
      this.temperaturaForm = this.formBuilder.group({
      idParametro: '',
      Clientes_idClientes: '',
      valor: '',
      fecha: '',
      Arduino_idArduino: ''
    });

  }

  onSubmit() {
    this.temperatureService.create(
      this.temperaturaForm.get('idParametro').value,
      this.temperaturaForm.get('Clientes_idClientes').value,
      this.temperaturaForm.get('valor').value,
      this.temperaturaForm.get('fecha').value,
      this.temperaturaForm.get('Arduino_idArduino').value
    ).subscribe(serverResponse=>{
        this.router.navigate(['/temperatures']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/temperatures']);
  }

}
