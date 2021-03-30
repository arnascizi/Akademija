import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../shared/user';
import {ActivatedRoute} from '@angular/router';
import {UsersService} from '../services/users.service';
import {map, switchMap} from 'rxjs/operators';
import {Comment} from '../shared/comment';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent implements OnInit {
  userId: Observable<string>;
  user$: Observable<User>;
  comments$: Observable<Comment[]>;
  constructor(private route: ActivatedRoute,
              private usersService: UsersService) { }

  ngOnInit(): void {
    this.userId = this.route.paramMap.pipe(map(
      paramMap => paramMap.get('id')
    ));

    this.user$ = this.userId.pipe(switchMap(
      id => this.usersService.getUser(id)
    ));

    this.comments$ = this.userId.pipe(switchMap(
      id => this.usersService.getUserComments(id)
    ));

  }

}
