import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../shared/user';
import {Comment} from '../shared/comment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(`/api/users`);
  }

  getUser(id: string): Observable<User> {
    return this.httpClient.get<User>(`/api/users/${id}`);
  }

  getUserComments(id: string): Observable<Comment[]> {
    return this.httpClient.get<Comment[]>(`/api/users/${id}/comments`);
  }

  deleteUser(id: string): Observable<User> {
    return this.httpClient.delete<User>(`api/users/${id}`);
  }

  addUser(user: User): Observable<User> {
    return this.httpClient.post<User>(`/api/users`, user);
  }
}
