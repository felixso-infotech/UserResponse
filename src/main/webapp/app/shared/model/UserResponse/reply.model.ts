import { Moment } from 'moment';
import { ILove } from 'app/shared/model/UserResponse/love.model';

export interface IReply {
  id?: number;
  description?: string;
  userId?: string;
  dateAndTime?: Moment;
  commentId?: number;
  loves?: ILove[];
}

export class Reply implements IReply {
  constructor(
    public id?: number,
    public description?: string,
    public userId?: string,
    public dateAndTime?: Moment,
    public commentId?: number,
    public loves?: ILove[]
  ) {}
}
