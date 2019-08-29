package com.felixsoinfotech.user_response.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Comment entity.
 */
public class CommentDTO implements Serializable {

    private Long id;

    private String description;

    private String userId;

    private Long commitedActivityId;

    private Long completedChallengeId;

    private ZonedDateTime dateAndTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommentDTO commentDTO = (CommentDTO) o;
        if (commentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), commentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", userId='" + getUserId() + "'" +
            ", commitedActivityId=" + getCommitedActivityId() +
            ", completedChallengeId=" + getCompletedChallengeId() +
            ", dateAndTime='" + getDateAndTime() + "'" +
            "}";
    }
}
