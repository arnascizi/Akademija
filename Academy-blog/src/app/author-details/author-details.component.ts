import {Component, Input, OnInit} from '@angular/core';
import {Author} from '../shared/author';
import {AuthorsService} from '../services/authors.service';

@Component({
  selector: 'app-author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.scss']
})
export class AuthorDetailsComponent implements OnInit {
  @Input() author: Author;
  constructor() { }

  ngOnInit(): void {
  }
}
