import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { concat, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { PostsService } from '../services/posts.service';
import { AuthorValidator } from './author.validator';
import { blockedAuthorValidator } from './blocked-author.validator';
import { explicitValidator } from './explicit.validator';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.scss']
})
export class NewPostComponent implements OnInit {
  public newPostForm: FormGroup;
  public maxContentValue = 100;
  public remainingChars: Observable<number>;

  constructor(
    private postService: PostsService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.newPostForm = this.fb.group({
      author: ['', {
        Validators: [Validators.required,
        Validators.pattern('^[A-Za-z]*$')],
        updateOn: 'blur',
        asyncValidators: [blockedAuthorValidator(this.postService)],
      },],
      title: ['', [Validators.required]],
      content: ['',
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(this.maxContentValue),
          explicitValidator,
        ]
      ],
    },
      { validators: AuthorValidator }
    );
    this.remainingChars = concat(of(''), this.content.valueChanges).pipe(
      map((content) => {
        return this.maxContentValue - (content?.length || 0);
      })
    );
  }

  submitForm() {
    this.postService.addPost(this.newPostForm.value).subscribe(() => {
      this.reset();
    })
  }

  reset() {
    this.newPostForm.reset();
  }

  get author() {
    return this.newPostForm.get('author');
  }
  get title() {
    return this.newPostForm.get('title');
  }

  get content() {
    return this.newPostForm.get('content');
  }
}
