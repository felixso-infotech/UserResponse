/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.felixsoinfotech.user_response.model;

import java.time.ZonedDateTime;


/**
 * 
 */
public class CommentAggregate {

	private Long commentId;

    private String description;

    private String userId;

    private Long commitedActivityId;

    private Long completedChallengeId;

    private ZonedDateTime CreatedDate;
    
    private String profilePicture;
    
	private String profilePictureContentType;
	 
	private String firstName;

    private String lastName;
    
    private String timeElapsed;
    
    private Long noOfLoves;
    
    private boolean isLiked;
    
    private Long noOfReplies;

	/**
	 * @return the commentId
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the commitedActivityId
	 */
	public Long getCommitedActivityId() {
		return commitedActivityId;
	}

	/**
	 * @param commitedActivityId the commitedActivityId to set
	 */
	public void setCommitedActivityId(Long commitedActivityId) {
		this.commitedActivityId = commitedActivityId;
	}

	/**
	 * @return the completedChallengeId
	 */
	public Long getCompletedChallengeId() {
		return completedChallengeId;
	}

	/**
	 * @param completedChallengeId the completedChallengeId to set
	 */
	public void setCompletedChallengeId(Long completedChallengeId) {
		this.completedChallengeId = completedChallengeId;
	}

	/**
	 * @return the createdDate
	 */
	public ZonedDateTime getCreatedDate() {
		return CreatedDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(ZonedDateTime createdDate) {
		CreatedDate = createdDate;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the profilePictureContentType
	 */
	public String getProfilePictureContentType() {
		return profilePictureContentType;
	}

	/**
	 * @param profilePictureContentType the profilePictureContentType to set
	 */
	public void setProfilePictureContentType(String profilePictureContentType) {
		this.profilePictureContentType = profilePictureContentType;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the timeElapsed
	 */
	public String getTimeElapsed() {
		return timeElapsed;
	}

	/**
	 * @param timeElapsed the timeElapsed to set
	 */
	public void setTimeElapsed(String timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	/**
	 * @return the noOfLoves
	 */
	public Long getNoOfLoves() {
		return noOfLoves;
	}

	/**
	 * @param noOfLoves the noOfLoves to set
	 */
	public void setNoOfLoves(Long noOfLoves) {
		this.noOfLoves = noOfLoves;
	}

	/**
	 * @return the isLiked
	 */
	public boolean isLiked() {
		return isLiked;
	}

	/**
	 * @param isLiked the isLiked to set
	 */
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	/**
	 * @return the noOfReplies
	 */
	public Long getNoOfReplies() {
		return noOfReplies;
	}

	/**
	 * @param noOfReplies the noOfReplies to set
	 */
	public void setNoOfReplies(Long noOfReplies) {
		this.noOfReplies = noOfReplies;
	}
      
    

}
