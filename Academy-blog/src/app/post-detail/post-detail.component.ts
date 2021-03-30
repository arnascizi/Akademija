import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../shared/post';
import { PostsService } from '../services/posts.service';
import {map, switchMap} from 'rxjs/operators';
import {Observable, pipe} from 'rxjs';
import {Comment} from '../shared/comment';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})
export class PostDetailComponent implements OnInit {
  postId: Observable<string>;
  post$: Observable<Post>;
  comments$: Observable<Comment[]>;
  post: Post;

  constructor(
    private postService: PostsService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.postId = this.route.paramMap.pipe(
      map(paramMap => paramMap.get('id'))
    );

    this.post$ = this.postId.pipe(
      switchMap(id => this.postService.getPost(id))
    );

    this.comments$ = this.postId.pipe(
      switchMap(id => this.postService.getPostComments(id))
    );
  }

  addLike(post: Post): void {
    this.postService.addLike(post).subscribe();
  }

  removeLike(post: Post): void {
    this.postService.removeLike(post).subscribe();
  }
}
