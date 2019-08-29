import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UserResponseSharedModule } from 'app/shared';
import {
  LoveComponent,
  LoveDetailComponent,
  LoveUpdateComponent,
  LoveDeletePopupComponent,
  LoveDeleteDialogComponent,
  loveRoute,
  lovePopupRoute
} from './';

const ENTITY_STATES = [...loveRoute, ...lovePopupRoute];

@NgModule({
  imports: [UserResponseSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [LoveComponent, LoveDetailComponent, LoveUpdateComponent, LoveDeleteDialogComponent, LoveDeletePopupComponent],
  entryComponents: [LoveComponent, LoveUpdateComponent, LoveDeleteDialogComponent, LoveDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class UserResponseLoveModule {}
