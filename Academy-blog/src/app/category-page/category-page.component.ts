import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {map, switchMap} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {CategoriesService} from '../services/categories.service';
import {Category} from '../shared/category';
import {Post} from '../shared/post';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.scss']
})
export class CategoryPageComponent implements OnInit {
  categoryId$: Observable<string>;
  category$: Observable<Category>;
  posts$: Observable<Post[]>;

  constructor(
    private route: ActivatedRoute,
    private categoriesService: CategoriesService
  ) { }

  ngOnInit(): void {
    this.categoryId$ = this.route.paramMap.pipe(
      map(
        paramMap => paramMap.get('id')));

    this.category$ = this.categoryId$.pipe(
      switchMap(
        id => this.categoriesService.getCategory(id)));

    this.posts$ = this.categoryId$.pipe(
      switchMap(
        id => this.categoriesService.getCategoryPosts(id)));
  }
}
