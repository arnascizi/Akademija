import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Comment} from '../shared/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  constructor(
    private httpClient: HttpClient
  ) { }

  deleteComment(id: string): Observable<Comment> {
    return this.httpClient.delete<Comment>(`api/comments/${id}`);
  }
}
