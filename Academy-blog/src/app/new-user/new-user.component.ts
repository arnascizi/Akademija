import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {concat, Observable, of} from 'rxjs';
import {PostsService} from '../services/posts.service';
import {blockedAuthorValidator} from '../new-post/blocked-author.validator';
import {explicitValidator} from '../new-post/explicit.validator';
import {AuthorValidator} from '../new-post/author.validator';
import {map} from 'rxjs/operators';
import {UsersService} from '../services/users.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {
  public newUserForm: FormGroup;
  // public maxContentValue = 100;
  // public remainingChars: Observable<number>;

  constructor(
    private usersService: UsersService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.newUserForm = this.fb.group({
      firstName: ['', Validators.required, Validators.pattern('^[A-Za-z]*$')],
      lastName: ['', Validators.required, Validators.pattern('^[A-Za-z]*$')],
      email: ['', Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$')]
    });
  }

  submitForm(): void {
    this.usersService.addUser(this.newUserForm.value).subscribe(() => {
      this.reset();
    });
  }

  reset(): void {
    this.newUserForm.reset();
  }

  get firstName() {
    return this.newUserForm.get('firstName');
  }

  get lastName() {
    return this.newUserForm.get('lastName');
  }

  get email() {
    return this.newUserForm.get('email');
  }
}
