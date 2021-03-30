import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Author} from '../shared/author';
import {Post} from '../shared/post';
import {ActivatedRoute} from '@angular/router';
import {AuthorsService} from '../services/authors.service';
import {map, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-author-page',
  templateUrl: './author-page.component.html',
  styleUrls: ['./author-page.component.scss']
})
export class AuthorPageComponent implements OnInit {
  authorId: Observable<string>;
  author$: Observable<Author>;
  posts$: Observable<Post[]>;
  constructor(
    private route: ActivatedRoute,
    private authorsService: AuthorsService
  ) { }

  ngOnInit(): void {
    this.authorId = this.route.paramMap.pipe(map(paramMap => paramMap.get('id')));

    this.author$ = this.authorId.pipe(switchMap(id => this.authorsService.getAuthor(id)));
    this.posts$ = this.authorId.pipe(switchMap(id => this.authorsService.getAuthorPosts(id)));
  }


}
