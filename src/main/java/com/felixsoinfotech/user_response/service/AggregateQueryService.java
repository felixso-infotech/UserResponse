package com.felixsoinfotech.user_response.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.felixsoinfotech.user_response.model.CountAggregate;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;

public interface AggregateQueryService {

	 /**
     * Get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrieve comments,pageable the pagination information
     * @return the list of entities
     */
    Page<CommentDTO> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId);
    
    /**
     * Get number of comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrieve comments
     * @return the list of entities
     */
    Long findNumberOfCommentsByCommitedActivityId(Long commitedActivityId);
    
    /**
     * Get all the replies by commentId.
     *
     * @param commentId the commentId to retrieve replies,pageable the pagination information
     * @return the list of entities
     */
    Page<ReplyDTO> findAllRepliesByCommentId(Pageable pageable,Long commentId);
    
    /**
     * Get number of replies by commentId.
     *
     * @param commentId the activity id to retrieve replies
     * @return the number of entities
     */
    Long findNumberOfRepliesByCommentId(Long commentId);
    
    /**
     * Get number of loves by commitedActivityId.
     *
     * @param commitedActivityId the commitedActivity id to get number of loves
     * @return the number of entities
     */
    Long findNumberOfLovesByCommitedActivityId(Long commitedActivityId);
    
    /**
     * Get number of loves by commentId.
     *
     * @param commentId the commentId id to get number of loves
     * @return the number of entities
     */
    Long findNumberOfLovesByCommentId(Long commentId);
    
    /**
     * Get number of loves by replyId.
     *
     * @param replyId the replyId id to get number of loves
     * @return the number of entities
     */
    Long findNumberOfLovesByReplyId(Long replyId);

    /**
     * Get CountAggregate.
     *
     * @param commitedActivityId the commitedActivityId of the entity
     * @return the entity
     */
	Optional<CountAggregate> findCountOfCommentsAndLikesByCommitedActivityId(Long commitedActivityId);
}
