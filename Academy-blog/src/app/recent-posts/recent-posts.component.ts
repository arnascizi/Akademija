import { Component, OnInit } from '@angular/core';
import { PostsService } from '../services/posts.service';
import { map } from 'rxjs/operators';
import { Post } from '../shared/post';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-recent-posts',
  templateUrl: './recent-posts.component.html',
  styleUrls: ['./recent-posts.component.scss']
})
export class RecentPostsComponent implements OnInit {
  posts$: Observable<Post[]>;

  constructor(private postService: PostsService) { }

  ngOnInit(): void {
    this.posts$ = this.postService.getRecentPosts(3);
  }
}
