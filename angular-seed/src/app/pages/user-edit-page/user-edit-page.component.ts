import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-user-edit-page',
  templateUrl: './user-edit-page.component.html',
  styleUrls: ['./user-edit-page.component.css'],
  
})
export class UserEditPageComponent implements OnInit {
  userForm: FormGroup; 
  constructor(
    public UsersService: UsersService,
    public formBuilder: FormBuilder,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
      this.userForm = this.formBuilder.group({
      email: '',
      password: '',
      name: '',
      lastname: '',
      image: ''
    });

  }

  onSubmit() {
    this.UsersService.create(
      this.userForm.get('email').value,
      this.userForm.get('password').value,
      this.userForm.get('name').value,
      this.userForm.get('lastname').value,
      this.userForm.get('image').value
    ).subscribe(serverResponse=>{
        this.router.navigate(['/users']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/users']);
  }

}
