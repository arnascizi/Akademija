import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {PostsService} from '../services/posts.service';
import {Post} from '../shared/post';

@Component({
  selector: 'app-most-viewed-posts',
  templateUrl: './most-viewed-posts.component.html',
  styleUrls: ['./most-viewed-posts.component.scss']
})
export class MostViewedPostsComponent implements OnInit {
  posts$: Observable<Post[]>;
  constructor(private postService: PostsService) { }

  ngOnInit(): void {
    this.posts$ = this.postService.getMostViewedPosts(5);
  }

}
