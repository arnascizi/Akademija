import {Component, Input, OnInit} from '@angular/core';
import {Observable, pipe} from 'rxjs';
import {Post} from '../shared/post';
import {ActivatedRoute} from '@angular/router';
import {PostsService} from '../services/posts.service';
import {map, switchMap} from 'rxjs/operators';
import {Comment} from '../shared/comment';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {
  post$: Observable<Post>;
  comments$: Observable<Comment[]>;
  postId: Observable<string>;
  @Input() comments: Comment[];
  constructor(
    private route: ActivatedRoute,
    private postsService: PostsService
  ) { }

  ngOnInit(): void {
    this.postId = this.route.paramMap.pipe(
      map(paramMap => paramMap.get('id')
    ));

    this.post$ = this.postId.pipe(
      switchMap(id => this.postsService.getPost(id))
    );

    this.comments$ = this.postId.pipe(
      switchMap(id => this.postsService.getPostComments(id))
    );
  }

}
