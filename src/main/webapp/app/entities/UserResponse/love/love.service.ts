import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ILove } from 'app/shared/model/UserResponse/love.model';

type EntityResponseType = HttpResponse<ILove>;
type EntityArrayResponseType = HttpResponse<ILove[]>;

@Injectable({ providedIn: 'root' })
export class LoveService {
  public resourceUrl = SERVER_API_URL + 'api/loves';

  constructor(private http: HttpClient) {}

  create(love: ILove): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(love);
    return this.http
      .post<ILove>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(love: ILove): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(love);
    return this.http
      .put<ILove>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ILove>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ILove[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(love: ILove): ILove {
    const copy: ILove = Object.assign({}, love, {
      dateAndTime: love.dateAndTime != null && love.dateAndTime.isValid() ? love.dateAndTime.toJSON() : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dateAndTime = res.body.dateAndTime != null ? moment(res.body.dateAndTime) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((love: ILove) => {
        love.dateAndTime = love.dateAndTime != null ? moment(love.dateAndTime) : null;
      });
    }
    return res;
  }
}
