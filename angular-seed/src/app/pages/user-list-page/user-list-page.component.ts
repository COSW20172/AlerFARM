import { Component, OnInit } from '@angular/core';
import { User } from "../../models/User";
import { UsersService } from '../../services/users.service'

@Component({
  selector: 'user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.css']
})
export class UserListPageComponent implements OnInit {
  private usuarios: User[] = [];
  
      constructor(public usersService: UsersService) {
  
      }

      ngOnInit() {
          this.usersService.list().subscribe(usersResponse => {
              this.usuarios = usersResponse;
          })
      }

}