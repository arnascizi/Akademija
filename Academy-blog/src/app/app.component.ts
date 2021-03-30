import {Component, Input, OnInit} from '@angular/core';
import {Category} from './shared/category';
import {Observable} from 'rxjs';
import {CategoriesService} from './services/categories.service';
import {MenuItem} from './shared/menu-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  categories$: Observable<Category[]>;
  menuItems: MenuItem[];

  constructor(private categoriesService: CategoriesService) {
  }

  ngOnInit(): void {
    this.menuItems = [
      {
        path: '/home',
        title: 'Home'
      },
      {
        path: '/authors',
        title: 'Authors'
      },
      {
        path: '/posts/add',
        title: 'Write a post'
      },
      {
        path: '/users',
        title: 'Users'
      },
      {
        path: '/register',
        title: 'Register'
      }
    ];
    this.categories$ = this.categoriesService.getCategories();
  }

}
