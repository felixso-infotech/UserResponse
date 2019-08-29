package com.felixsoinfotech.user_response.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Love entity.
 */
public class LoveDTO implements Serializable {

    private Long id;

    private String userId;

    private Long commitedActivityId;

    private Long completedChallengeId;

    private ZonedDateTime dateAndTime;

    private Long commentId;

    private Long replyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCommitedActivityId() {
        return commitedActivityId;
    }

    public void setCommitedActivityId(Long commitedActivityId) {
        this.commitedActivityId = commitedActivityId;
    }

    public Long getCompletedChallengeId() {
        return completedChallengeId;
    }

    public void setCompletedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
    }

    public ZonedDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoveDTO loveDTO = (LoveDTO) o;
        if (loveDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), loveDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LoveDTO{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", commitedActivityId=" + getCommitedActivityId() +
            ", completedChallengeId=" + getCompletedChallengeId() +
            ", dateAndTime='" + getDateAndTime() + "'" +
            ", comment=" + getCommentId() +
            ", reply=" + getReplyId() +
            "}";
    }
}
