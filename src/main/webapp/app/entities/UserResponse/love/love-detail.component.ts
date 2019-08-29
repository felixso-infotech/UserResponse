import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ILove } from 'app/shared/model/UserResponse/love.model';

@Component({
  selector: 'jhi-love-detail',
  templateUrl: './love-detail.component.html'
})
export class LoveDetailComponent implements OnInit {
  love: ILove;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ love }) => {
      this.love = love;
    });
  }

  previousState() {
    window.history.back();
  }
}
