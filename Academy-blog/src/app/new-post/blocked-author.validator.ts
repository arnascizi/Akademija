import { AbstractControl, ValidationErrors } from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { PostsService } from '../services/posts.service';
export function blockedAuthorValidator(postService: PostsService) {
  return (control: AbstractControl): Observable<ValidationErrors | null> => {
    return postService
    .validateName(control.value)
    .pipe(map((valid) => (valid ? null : { blockedName: true })));
  };
}
