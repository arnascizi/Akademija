import {Component, Input, OnInit} from '@angular/core';
import {Comment} from '../shared/comment';
import {Observable} from 'rxjs';
import {User} from '../shared/user';
import {ActivatedRoute} from '@angular/router';
import {UsersService} from '../services/users.service';

@Component({
  selector: 'app-comment-details',
  templateUrl: './comment-details.component.html',
  styleUrls: ['./comment-details.component.scss']
})
export class CommentDetailsComponent implements OnInit {
  @Input() comment: Comment;
  user$: Observable<User>;

  constructor(private usersService: UsersService) {
  }

  ngOnInit(): void {
    this.user$ = this.usersService.getUser(this.comment.userId);
  }

}
