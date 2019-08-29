package com.felixsoinfotech.user_response.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Comment entity.
 * @author Anjali
 */
@ApiModel(description = "Comment entity. @author Anjali")
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "commited_activity_id")
    private Long commitedActivityId;

    @Column(name = "completed_challenge_id")
    private Long completedChallengeId;

    @Column(name = "date_and_time")
    private ZonedDateTime dateAndTime;

    @OneToMany(mappedBy = "comment",cascade=CascadeType.ALL)
    private Set<Reply> replies = new HashSet<>();
    @OneToMany(mappedBy = "comment",cascade=CascadeType.ALL)
    private Set<Love> loves = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Comment description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public Comment userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCommitedActivityId() {
        return commitedActivityId;
    }

    public Comment commitedActivityId(Long commitedActivityId) {
        this.commitedActivityId = commitedActivityId;
        return this;
    }

    public void setCommitedActivityId(Long commitedActivityId) {
        this.commitedActivityId = commitedActivityId;
    }

    public Long getCompletedChallengeId() {
        return completedChallengeId;
    }

    public Comment completedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
        return this;
    }

    public void setCompletedChallengeId(Long completedChallengeId) {
        this.completedChallengeId = completedChallengeId;
    }

    public ZonedDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Comment dateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public void setDateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public Comment replies(Set<Reply> replies) {
        this.replies = replies;
        return this;
    }

    public Comment addReplies(Reply reply) {
        this.replies.add(reply);
        reply.setComment(this);
        return this;
    }

    public Comment removeReplies(Reply reply) {
        this.replies.remove(reply);
        reply.setComment(null);
        return this;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public Set<Love> getLoves() {
        return loves;
    }

    public Comment loves(Set<Love> loves) {
        this.loves = loves;
        return this;
    }

    public Comment addLoves(Love love) {
        this.loves.add(love);
        love.setComment(this);
        return this;
    }

    public Comment removeLoves(Love love) {
        this.loves.remove(love);
        love.setComment(null);
        return this;
    }

    public void setLoves(Set<Love> loves) {
        this.loves = loves;
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
        Comment comment = (Comment) o;
        if (comment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", userId='" + getUserId() + "'" +
            ", commitedActivityId=" + getCommitedActivityId() +
            ", completedChallengeId=" + getCompletedChallengeId() +
            ", dateAndTime='" + getDateAndTime() + "'" +
            "}";
    }
}
