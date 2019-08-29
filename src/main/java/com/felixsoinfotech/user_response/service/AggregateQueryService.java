package com.felixsoinfotech.user_response.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.felixsoinfotech.user_response.service.dto.CommentDTO;

public interface AggregateQueryService {

	 /**
     * Get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrive comments,pageable the pagination information
     * @return the list of entities
     */
    //Page<CommentDTO> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId);
}
