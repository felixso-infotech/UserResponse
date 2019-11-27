package com.felixsoinfotech.user_response.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

import com.felixsoinfotech.user_response.model.CommentAggregate;
import com.felixsoinfotech.user_response.model.CountAggregate;
import com.felixsoinfotech.user_response.model.ReplyAggregate;
import com.felixsoinfotech.user_response.service.AggregateQueryService;

/**
 * REST controller for managing user response queries.
 */
@RestController
@RequestMapping("/api/query")
public class UserResponseAggregateQueryResource {

	private final Logger log = LoggerFactory.getLogger(UserResponseAggregateQueryResource.class);

	@Autowired
	private AggregateQueryService aggregateQueryService;

	
	/**
	 * GET /comments : get number of comments by commitedActivityId.
	 *
	 * @param commitedActivityId
	 *            the activity id to retrieve number of comments
	 * @return the ResponseEntity with status 200 (OK) and the number of comments
	 *         in body
	 */
	@GetMapping("/countofcomments-likes/{commitedActivityId}")
	@Timed
	public ResponseEntity<CountAggregate> getCountOfCommentsAndLikesByCommitedActivityId(@PathVariable Long commitedActivityId) {
		log.debug("REST request to get number of Comments by commitedActivityId");
		Optional<CountAggregate> countAggregate = aggregateQueryService.findCountOfCommentsAndLikesByCommitedActivityId(commitedActivityId);
		 return ResponseUtil.wrapOrNotFound(countAggregate);
	}
	
	
	/**
	 * GET /comments : get all the comments by commitedActivityId.
	 *
	 * @param commitedActivityId
	 *            the activity id to retrieve comments,pageable the pagination
	 *            information
	 * @return the ResponseEntity with status 200 (OK) and the list of comments
	 *         in body
	 */
	@GetMapping("/get-comments/{commitedActivityId}")
	@Timed
	public ResponseEntity<List<CommentAggregate>> getAllCommentsByCommitedActivityId(Pageable pageable,@PathVariable Long commitedActivityId) {
		
		log.debug("REST request to get a page of Comments");
		
		Page<CommentAggregate> page = aggregateQueryService.findAllCommentsByCommitedActivityId(pageable,commitedActivityId);
		
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,"/query/get-comments/{commitedActivityId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * GET /comments : get number of comments by commitedActivityId.
	 *
	 * @param commitedActivityId
	 *            the activity id to retrieve number of comments
	 * @return the ResponseEntity with status 200 (OK) and the number of comments
	 *         in body
	 */
	@GetMapping("/numberofcomments-by-commitedActivityId/{commitedActivityId}")
	@Timed
	public ResponseEntity<Long> getNumberOfCommentsByCommitedActivityId(@PathVariable Long commitedActivityId) {
		log.debug("REST request to get number of Comments by commitedActivityId");
		Long numberOfComments = aggregateQueryService.findNumberOfCommentsByCommitedActivityId(commitedActivityId);
		return ResponseEntity.ok().body(numberOfComments);
	}
	
	/**
     * GET  /replies : get all the replies by commentId.
     *
     * @param commentId the commentId to retrieve replies,pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of replies in body
     */
    @GetMapping("/get-replies/{commentId}")
    @Timed
    public ResponseEntity<List<ReplyAggregate>> getAllRepliesByCommentId(Pageable pageable,@PathVariable Long commentId) {
        log.debug("REST request to get a page of Replies by commentId");
        
        Page<ReplyAggregate> page = aggregateQueryService.findAllRepliesByCommentId(pageable,commentId);
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/query/get-replies/{commentId}");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

	/**
	 * GET /comments : get number of replies by commentId.
	 *
	 * @param commentId
	 *            the commentId to retrieve number of replies
	 * @return the ResponseEntity with status 200 (OK) and the number of replies
	 *         in body
	 */
	@GetMapping("/numberofreplies-by-commentId/{commentId}")
	@Timed
	public ResponseEntity<Long> getNumberOfRepliesByCommentId(@PathVariable Long commentId) {
		log.debug("REST request to get number of replies by comment id");
		Long numberOfReplies = aggregateQueryService.findNumberOfRepliesByCommentId(commentId);
		return ResponseEntity.ok().body(numberOfReplies);
	}
	
	 /**
     * GET  /loves : get number of loves of commitedActivity.
     *
     * @param commitedActivityId the commitedActivityId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/numberofloves-by-commitedActivityId/{commitedActivityId}")
    @Timed
    public ResponseEntity<Long> getNumberOfLovesByCommitedActivityId(@PathVariable Long commitedActivityId){
        log.debug("REST request to get number of Loves of commitedActivity{}",commitedActivityId);
        Long numberOfLovesOfCommitedActivity= aggregateQueryService.findNumberOfLovesByCommitedActivityId(commitedActivityId);
        return ResponseEntity.ok().body(numberOfLovesOfCommitedActivity);
    }

    /**
     * GET  /loves : get number of loves of comments.
     *
     * @param commentId the commentId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/numberofloves-by-commentId/{commentId}")
    @Timed
    public ResponseEntity<Long> getNumberOfLovesByCommentId(@PathVariable Long commentId){
        log.debug("REST request to get number of Loves of comments{}",commentId);
        Long numberOfLovesOfComment= aggregateQueryService.findNumberOfLovesByCommentId(commentId);
        return ResponseEntity.ok().body(numberOfLovesOfComment);
    }
    
    /**
     * GET  /loves : get number of loves of replies.
     *
     * @param replyId the replyId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/numberofloves-by-replyId/{replyId}")
    @Timed
    public ResponseEntity<Long> getNumberOfLovesByReplyId(@PathVariable Long replyId){
        log.debug("REST request to get number of Loves of replies{}",replyId);
        Long numberOfLovesOfReply= aggregateQueryService.findNumberOfLovesByReplyId(replyId);
        return ResponseEntity.ok().body(numberOfLovesOfReply);
    }
    
    /**
     * GET  /loves : get number of loves of replies.
     *
     * @param replyId the replyId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/isLiked/{commitedActivityId}/{userId}")
    @Timed
    public Boolean isLikedCommittedActivityByUser(@PathVariable Long commitedActivityId,@PathVariable String userId){
        log.debug("REST request to isliked committed activity by user{}",commitedActivityId,userId);
        
        Boolean isLiked= aggregateQueryService.isLikedCommittedActivityByUser(commitedActivityId,userId);
        
        return isLiked;
    }

    
    
    /**
     * GET  /loves : get number of loves of replies.
     *
     * @param replyId the replyId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/isLikedComment/{commentId}/{userId}")
    @Timed
    public Boolean isLikedCommentByUser(@PathVariable Long commentId,@PathVariable String userId){
        log.debug("REST request to isliked comment by user{}",commentId,userId);
        
        Boolean isLiked= aggregateQueryService.isLikedCommentByUser(commentId,userId);
        
        return isLiked;
    }
    
    
    
    /**
     * GET  /loves : get number of loves of replies.
     *
     * @param replyId the replyId to get number of loves
     * @return the ResponseEntity with status 200 (OK) and the number of loves in body
     */
    @GetMapping("/isLikedReply/{replyId}/{userId}")
    @Timed
    public Boolean isLikedReplyByUser(@PathVariable Long replyId,@PathVariable String userId){
    	
        log.debug("REST request to isliked reply by user{}",replyId,userId);
        
        Boolean isLiked= aggregateQueryService.isLikedReplyByUser(replyId,userId);
        
        return isLiked;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
