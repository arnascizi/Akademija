import {Component, Input, OnInit} from '@angular/core';
import {Category} from '../shared/category';
import {MenuItem} from '../shared/menu-item';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  @Input() categories: Category[];
  @Input() menuItems: MenuItem[];

  constructor() { }

  ngOnInit(): void {
  }

}
