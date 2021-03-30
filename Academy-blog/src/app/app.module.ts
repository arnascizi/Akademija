import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PostComponent } from './post/post.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { RecentPostsComponent } from './recent-posts/recent-posts.component';
import { NewPostComponent } from './new-post/new-post.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CategoryPageComponent } from './category-page/category-page.component';
import { PostListComponent } from './post-list/post-list.component';
import { AuthorDetailsComponent } from './author-details/author-details.component';
import { AuthorPageComponent } from './author-page/author-page.component';
import { AuthorsPageComponent } from './authors-page/authors-page.component';
import { MostViewedPostsComponent } from './most-viewed-posts/most-viewed-posts.component';
import { CommentComponent } from './comment/comment.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { NewCommentComponent } from './new-comment/new-comment.component';
import { CommentDetailsComponent } from './comment-details/comment-details.component';
import { UserPageComponent } from './user-page/user-page.component';
import { UsersPageComponent } from './users-page/users-page.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { NewUserComponent } from './new-user/new-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    PostDetailComponent,
    RecentPostsComponent,
    NewPostComponent,
    HomeComponent,
    NavbarComponent,
    CategoryPageComponent,
    PostListComponent,
    AuthorDetailsComponent,
    AuthorPageComponent,
    AuthorsPageComponent,
    MostViewedPostsComponent,
    CommentComponent,
    CommentListComponent,
    NewCommentComponent,
    CommentDetailsComponent,
    UserPageComponent,
    UsersPageComponent,
    UserDetailsComponent,
    NewUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
