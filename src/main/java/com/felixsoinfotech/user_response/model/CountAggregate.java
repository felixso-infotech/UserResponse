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

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

public class CountAggregate {

    private Long noOfLoves;
    
	private Long noOfComments;
	
	private List<String> likedUserPhotos=new ArrayList<String>();

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
	 * @return the noOfComments
	 */
	public Long getNoOfComments() {
		return noOfComments;
	}

	/**
	 * @param noOfComments the noOfComments to set
	 */
	public void setNoOfComments(Long noOfComments) {
		this.noOfComments = noOfComments;
	}

	/**
	 * @return the likedUserPhotos
	 */
	public List<String> getLikedUserPhotos() {
		return likedUserPhotos;
	}

	/**
	 * @param likedUserPhotos the likedUserPhotos to set
	 */
	public void setLikedUserPhotos(List<String> likedUserPhotos) {
		this.likedUserPhotos = likedUserPhotos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((likedUserPhotos == null) ? 0 : likedUserPhotos.hashCode());
		result = prime * result + ((noOfComments == null) ? 0 : noOfComments.hashCode());
		result = prime * result + ((noOfLoves == null) ? 0 : noOfLoves.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountAggregate other = (CountAggregate) obj;
		if (likedUserPhotos == null) {
			if (other.likedUserPhotos != null)
				return false;
		} else if (!likedUserPhotos.equals(other.likedUserPhotos))
			return false;
		if (noOfComments == null) {
			if (other.noOfComments != null)
				return false;
		} else if (!noOfComments.equals(other.noOfComments))
			return false;
		if (noOfLoves == null) {
			if (other.noOfLoves != null)
				return false;
		} else if (!noOfLoves.equals(other.noOfLoves))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountAggregate [noOfLoves=" + noOfLoves + ", noOfComments=" + noOfComments + ", likedUserPhotos="
				+ likedUserPhotos + "]";
	}  
	
	

}
