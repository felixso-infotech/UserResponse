package com.felixsoinfotech.user_response.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Reply entity.
 * @author Anjali
 */
@ApiModel(description = "Reply entity. @author Anjali")
@Entity
@Table(name = "reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "date_and_time")
    private ZonedDateTime dateAndTime;

    @ManyToOne
    @JsonIgnoreProperties("replies")
    private Comment comment;

    @OneToMany(mappedBy = "reply",cascade=CascadeType.ALL)
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

    public Reply description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public Reply userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ZonedDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Reply dateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public void setDateAndTime(ZonedDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Comment getComment() {
        return comment;
    }

    public Reply comment(Comment comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Set<Love> getLoves() {
        return loves;
    }

    public Reply loves(Set<Love> loves) {
        this.loves = loves;
        return this;
    }

    public Reply addLoves(Love love) {
        this.loves.add(love);
        love.setReply(this);
        return this;
    }

    public Reply removeLoves(Love love) {
        this.loves.remove(love);
        love.setReply(null);
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
        Reply reply = (Reply) o;
        if (reply.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reply.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reply{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", userId='" + getUserId() + "'" +
            ", dateAndTime='" + getDateAndTime() + "'" +
            "}";
    }
}
