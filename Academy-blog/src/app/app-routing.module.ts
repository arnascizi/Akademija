import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {NewPostComponent} from './new-post/new-post.component';
import {PostDetailComponent} from './post-detail/post-detail.component';
import {CategoryPageComponent} from './category-page/category-page.component';
import {AuthorsPageComponent} from './authors-page/authors-page.component';
import {AuthorPageComponent} from './author-page/author-page.component';
import {CommentComponent} from './comment/comment.component';
import {UsersPageComponent} from './users-page/users-page.component';
import {NewUserComponent} from './new-user/new-user.component';
import {UserPageComponent} from './user-page/user-page.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'category/:id', component: CategoryPageComponent},
  {path: 'home', component: HomeComponent},
  {path: 'posts/add', component: NewPostComponent},
  {path: 'post/:id', component: PostDetailComponent},
  {path: 'post/:id:/comments', component: CommentComponent},
  {path: 'authors', component: AuthorsPageComponent},
  {path: 'authors/:id', component: AuthorPageComponent},
  {path: 'users', component: UsersPageComponent},
  {path: 'users/:id', component: UserPageComponent},
  {path: 'register', component: NewUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
