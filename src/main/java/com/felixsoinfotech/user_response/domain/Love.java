package com.felixsoinfotech.user_response.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Love entity.
 * @author Anjali
 */
@ApiModel(description = "Love entity. @author Anjali")
@Entity
@Table(name = "love")
public class Love implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "commited_activity_id")
    private Long commitedActivityId;

    @Column(name = "completed_challenge_id")
    private Long completedChallengeId;

    @Column(name = "date_and_time")
    private ZonedDateTime dateAndTime;

    @ManyToOne
    @JsonIgnoreProperties("loves")
    private Comment comment;

    @ManyToOne
    @JsonIgnoreProperties("loves")
    private Reply reply;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public Love userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCommitedActivityId() {
        return commitedActivityId;
    }

    public Love commitedActivityId(Long commitedActivityId) {
        this.commitedActivityId = commitedActivityId;
        return this;
    }

    public void setCommitedActivityId(Long commitedActivityId) {
        this.commitedActivityId = commitedActivityId;
    }

    public Long getCompletedChallengeId() {
        return completedChallengeId;
    }

    public Love completedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
        return this;
    }

    public void setCompletedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
    }

    public ZonedDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Love dateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public void setDateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Comment getComment() {
        return comment;
    }

    public Love comment(Comment comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Reply getReply() {
        return reply;
    }

    public Love reply(Reply reply) {
        this.reply = reply;
        return this;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Love love = (Love) o;
        if (love.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), love.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Love{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", commitedActivityId=" + getCommitedActivityId() +
            ", completedChallengeId=" + getCompletedChallengeId() +
            ", dateAndTime='" + getDateAndTime() + "'" +
            "}";
    }
}
