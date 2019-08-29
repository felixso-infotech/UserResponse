package com.felixsoinfotech.user_response.model;

public class DeleteLoveModel {

	private String userId;
	
	private Long commitedActivityId;

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
	
}
