import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../shared/user';
import {UsersService} from '../services/users.service';

@Component({
  selector: 'app-users-page',
  templateUrl: './users-page.component.html',
  styleUrls: ['./users-page.component.scss']
})
export class UsersPageComponent implements OnInit {
  users$: Observable<User[]>;
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.users$ = this.userService.getUsers();
  }

}
