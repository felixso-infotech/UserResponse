package com.felixsoinfotech.user_response.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.user_response.repository.CommentRepository;
import com.felixsoinfotech.user_response.repository.LoveRepository;
import com.felixsoinfotech.user_response.repository.ReplyRepository;
import com.felixsoinfotech.user_response.service.AggregateQueryService;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.service.mapper.CommentMapper;
import com.felixsoinfotech.user_response.service.mapper.LoveMapper;
import com.felixsoinfotech.user_response.service.mapper.ReplyMapper;
import com.felixsoinfotech.user_response.web.rest.AggregateQueryResource;

/**
 * Service Implementation for managing queries in user response service.
 */
@Service
@Transactional
public class AggregateQueryServiceImpl implements AggregateQueryService {
	
	private final Logger log = LoggerFactory.getLogger(AggregateQueryServiceImpl.class);
	
	@Autowired
    private CommentRepository commentRepository;

	@Autowired
    private CommentMapper commentMapper;
	
	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
    private ReplyMapper replyMapper;
	
	@Autowired
	private LoveRepository loveRepository;

	@Autowired
    private LoveMapper loveMapper;

	/**
     * Get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrieve comments,pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommentDTO> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId) {
        log.debug("Request to get all Comments by commitedActivityId");
        return commentRepository.findAllCommentsByCommitedActivityId(pageable,commitedActivityId)
            .map(commentMapper::toDto);
    }
    
    /**
     *  Get number of comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrieve comments
     * @return the list of entities
     */
    public Long findNumberOfCommentsByCommitedActivityId(Long commitedActivityId){
    	log.debug("Request to get number of Comments by commitedActivityId");
        return commentRepository.findNumberOfCommentsByCommitedActivityId(commitedActivityId);
    }
    
    /**
     * Get all the replies by commentId.
     *
     * @param commentId the commentId to retrieve replies,pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReplyDTO> findAllRepliesByCommentId(Pageable pageable,Long commentId) {
        log.debug("Request to get all Replies by comment id");
        return replyRepository.findAllRepliesByCommentId(pageable,commentId)
            .map(replyMapper::toDto);
    }

    /**
     *  Get number of replies by commentId.
     *
     * @param commentId the commentId id to retrieve replies
     * @return the number of replies
     */
    public Long findNumberOfRepliesByCommentId(Long commentId){
    	log.debug("Request to get number of replies by commentId");
        return replyRepository.findNumberOfRepliesByCommentId(commentId);
    }
    
    /**
     *  Get number of loves by commitedActivityId.
     *
     * @param commitedActivityId the commitedActivity id to retrieve number of loves
     * @return the number of loves
     */
    public Long findNumberOfLovesByCommitedActivityId(Long commitedActivityId){
    	log.debug("Request to get number of loves by commitedActivityId");
        return loveRepository.findNumberOfLovesByCommitedActivityId(commitedActivityId);
    }
    

    /**
     *  Get number of loves by commentId.
     *
     * @param commentId the commentId to retrieve number of loves
     * @return the number of loves
     */
    public Long findNumberOfLovesByCommentId(Long commentId){
    	log.debug("Request to get number of loves by commentId");
        return loveRepository.findNumberOfLovesByCommentId(commentId);
    }
    
    /**
     *  Get number of loves by replyId.
     *
     * @param replyId the replyId to retrieve number of loves
     * @return the number of loves
     */
    public Long findNumberOfLovesByReplyId(Long replyId){
    	log.debug("Request to get number of loves by replyId");
        return loveRepository.findNumberOfLovesByReplyId(replyId);
    }
    

}
