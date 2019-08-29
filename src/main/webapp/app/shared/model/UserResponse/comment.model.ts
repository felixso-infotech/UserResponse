import { Moment } from 'moment';
import { IReply } from 'app/shared/model/UserResponse/reply.model';
import { ILove } from 'app/shared/model/UserResponse/love.model';

export interface IComment {
  id?: number;
  description?: string;
  userId?: string;
  commitedActivityId?: number;
  completedChallengeId?: number;
  dateAndTime?: Moment;
  replies?: IReply[];
  loves?: ILove[];
}

export class Comment implements IComment {
  constructor(
    public id?: number,
    public description?: string,
    public userId?: string,
    public commitedActivityId?: number,
    public completedChallengeId?: number,
    public dateAndTime?: Moment,
    public replies?: IReply[],
    public loves?: ILove[]
  ) {}
}
