import {Component, Input, OnInit} from '@angular/core';
import {Post} from '../shared/post';
import {PostsService} from '../services/posts.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Comment} from '../shared/comment';
import {Observable} from 'rxjs';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {
  @Input() post: Post;
  comments$: Observable<Comment[]>;

  constructor(private postService: PostsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.comments$ = this.postService.getPostComments(this.post.id);
  }
}
