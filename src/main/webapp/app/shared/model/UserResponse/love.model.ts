import { Moment } from 'moment';

export interface ILove {
  id?: number;
  userId?: string;
  commitedActivityId?: number;
  completedChallengeId?: number;
  dateAndTime?: Moment;
  commentId?: number;
  replyId?: number;
}

export class Love implements ILove {
  constructor(
    public id?: number,
    public userId?: string,
    public commitedActivityId?: number,
    public completedChallengeId?: number,
    public dateAndTime?: Moment,
    public commentId?: number,
    public replyId?: number
  ) {}
}
