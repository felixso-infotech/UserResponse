import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { ILove } from 'app/shared/model/UserResponse/love.model';
import { LoveService } from './love.service';
import { IComment } from 'app/shared/model/UserResponse/comment.model';
import { CommentService } from 'app/entities/UserResponse/comment';
import { IReply } from 'app/shared/model/UserResponse/reply.model';
import { ReplyService } from 'app/entities/UserResponse/reply';

@Component({
  selector: 'jhi-love-update',
  templateUrl: './love-update.component.html'
})
export class LoveUpdateComponent implements OnInit {
  love: ILove;
  isSaving: boolean;

  comments: IComment[];

  replies: IReply[];
  dateAndTime: string;

  constructor(
    private jhiAlertService: JhiAlertService,
    private loveService: LoveService,
    private commentService: CommentService,
    private replyService: ReplyService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ love }) => {
      this.love = love;
      this.dateAndTime = this.love.dateAndTime != null ? this.love.dateAndTime.format(DATE_TIME_FORMAT) : null;
    });
    this.commentService.query().subscribe(
      (res: HttpResponse<IComment[]>) => {
        this.comments = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.replyService.query().subscribe(
      (res: HttpResponse<IReply[]>) => {
        this.replies = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.love.dateAndTime = this.dateAndTime != null ? moment(this.dateAndTime, DATE_TIME_FORMAT) : null;
    if (this.love.id !== undefined) {
      this.subscribeToSaveResponse(this.loveService.update(this.love));
    } else {
      this.subscribeToSaveResponse(this.loveService.create(this.love));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<ILove>>) {
    result.subscribe((res: HttpResponse<ILove>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackCommentById(index: number, item: IComment) {
    return item.id;
  }

  trackReplyById(index: number, item: IReply) {
    return item.id;
  }
}
