import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UserResponseSharedModule } from 'app/shared';
import {
  ReplyComponent,
  ReplyDetailComponent,
  ReplyUpdateComponent,
  ReplyDeletePopupComponent,
  ReplyDeleteDialogComponent,
  replyRoute,
  replyPopupRoute
} from './';

const ENTITY_STATES = [...replyRoute, ...replyPopupRoute];

@NgModule({
  imports: [UserResponseSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [ReplyComponent, ReplyDetailComponent, ReplyUpdateComponent, ReplyDeleteDialogComponent, ReplyDeletePopupComponent],
  entryComponents: [ReplyComponent, ReplyUpdateComponent, ReplyDeleteDialogComponent, ReplyDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class UserResponseReplyModule {}
