import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Love } from 'app/shared/model/UserResponse/love.model';
import { LoveService } from './love.service';
import { LoveComponent } from './love.component';
import { LoveDetailComponent } from './love-detail.component';
import { LoveUpdateComponent } from './love-update.component';
import { LoveDeletePopupComponent } from './love-delete-dialog.component';
import { ILove } from 'app/shared/model/UserResponse/love.model';

@Injectable({ providedIn: 'root' })
export class LoveResolve implements Resolve<ILove> {
  constructor(private service: LoveService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Love> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Love>) => response.ok),
        map((love: HttpResponse<Love>) => love.body)
      );
    }
    return of(new Love());
  }
}

export const loveRoute: Routes = [
  {
    path: 'love',
    component: LoveComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'Loves'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'love/:id/view',
    component: LoveDetailComponent,
    resolve: {
      love: LoveResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Loves'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'love/new',
    component: LoveUpdateComponent,
    resolve: {
      love: LoveResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Loves'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'love/:id/edit',
    component: LoveUpdateComponent,
    resolve: {
      love: LoveResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Loves'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const lovePopupRoute: Routes = [
  {
    path: 'love/:id/delete',
    component: LoveDeletePopupComponent,
    resolve: {
      love: LoveResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Loves'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
