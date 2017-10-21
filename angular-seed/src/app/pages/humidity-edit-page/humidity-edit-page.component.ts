import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { HumidityService } from '../../services/humidity.service';

@Component({
  selector: 'app-humidity-edit-page',
  templateUrl: './humidity-edit-page.component.html',
  styleUrls: ['./humidity-edit-page.component.css'],
  
})
export class HumidityEditPageComponent implements OnInit {
  humidityForm: FormGroup; 
  constructor(
    public humidityService: HumidityService,
    public formBuilder: FormBuilder,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
      this.humidityForm = this.formBuilder.group({
      idParametro: '',
      clientes_idClientes: '',
      valor: '',
      fecha: ''
    });

  }

  onSubmit() {
    this.humidityService.create(
      this.humidityForm.get('idParametro').value,
      this.humidityForm.get('clientes_idClientes').value,
      this.humidityForm.get('valor').value,
      this.humidityForm.get('fecha').value
    ).subscribe(serverResponse=>{
        this.router.navigate(['/humiditys']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/humiditys']);
  }

}
