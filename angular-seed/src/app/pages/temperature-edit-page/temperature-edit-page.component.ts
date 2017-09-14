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
      id: '',
      valor: '',
      fecha: ''
    });

  }

  onSubmit() {
    this.temperatureService.create(
      this.temperaturaForm.get('id').value,
      this.temperaturaForm.get('valor').value,
      this.temperaturaForm.get('fecha').value
    ).subscribe(serverResponse=>{
        this.router.navigate(['/temperatures']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/temperatures']);
  }

}
