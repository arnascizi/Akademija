import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {catchError, mapTo} from 'rxjs/operators';
import {Post} from '../shared/post';
import {Comment} from '../shared/comment';
import {User} from '../shared/user';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  addPost(post: Post): Observable<Post> {
    return this.httpClient.post<Post>('/api/posts', post);
  }

  loadPosts(): Observable<Post[]> {
    return this.httpClient.get<Post[]>('api/posts');
  }

  getPost(id: string): Observable<Post | undefined> {
    return this.httpClient.get<Post>(`api/posts/${id}`);
  }

  addLike(post: Post): Observable<Post> {
    return this.httpClient.put<Post>(`api/posts/${post.id}`, {
      ...post,
      likes: post.likes + 1,
    });
  }

  removeLike(post: Post): Observable<Post> {
    return this.httpClient.put<Post>(`api/posts/${post.id}`, {
      ...post,
      likes: post.likes - 1,
    });
  }

  validateName(name): Observable<boolean> {
    return this.httpClient
      .get<unknown>(`https://empty-poetry-bf01.akademija.workers.dev/${name}`)
      .pipe(mapTo(true), catchError(() => of(false)));
  }

  getRecentPosts(limit: number): Observable<Post[]> {
    return this.httpClient.get<Post[]>(`/api/posts?_sort=created&_order=desc&_limit=${limit}`);
  }

  getMostViewedPosts(limit: number): Observable<Post[]> {
    return this.httpClient.get<Post[]>(`/api/posts?_sort=views&_order=desc&_start=0&_limit=${limit}`);
  }

  getPostComments(id: string): Observable<Comment[]> {
    return this.httpClient.get<Comment[]>(`/api/posts/${id}/comments`);
  }

  deletePost(id: string): Observable<Post> {
    return this.httpClient.delete<Post>(`api/posts/${id}`);
  }
}
