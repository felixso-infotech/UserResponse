package com.felixsoinfotech.user_response.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.user_response.domain.Comment;
import com.felixsoinfotech.user_response.domain.Love;
import com.felixsoinfotech.user_response.domain.Reply;
import com.felixsoinfotech.user_response.repository.CommentRepository;
import com.felixsoinfotech.user_response.repository.LoveRepository;
import com.felixsoinfotech.user_response.repository.ReplyRepository;
import com.felixsoinfotech.user_response.service.AggregateCommandService;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.service.mapper.CommentMapper;
import com.felixsoinfotech.user_response.service.mapper.LoveMapper;
import com.felixsoinfotech.user_response.service.mapper.ReplyMapper;

/**
 * Service Implementation for managing user response service.
 */
@Service
@Transactional
public class AggregateCommandServiceImpl implements AggregateCommandService{

	private final Logger log = LoggerFactory.getLogger(AggregateCommandServiceImpl.class);
	
	 @Autowired
	 private LoveRepository loveRepository;

	 @Autowired
	 private LoveMapper loveMapper;
	 
	 @Autowired
	 private CommentRepository commentRepository;

	 @Autowired
     private CommentMapper commentMapper;
	 
	 @Autowired
	 private ReplyRepository replyRepository;

	 @Autowired
	 private ReplyMapper replyMapper;


	 /**
     * Save a love.
     *
     * @param loveDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public LoveDTO saveLove(LoveDTO loveDTO) {
        log.debug("Request to save Love : {}", loveDTO);

        Love love = loveMapper.toEntity(loveDTO);
        love = loveRepository.save(love);
        return loveMapper.toDto(love);
    }
    
    /**
     * Save a comment.
     *
     * @param commentDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CommentDTO saveComment(CommentDTO commentDTO) {
        log.debug("Request to save Comment : {}", commentDTO);

        Comment comment = commentMapper.toEntity(commentDTO);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    /**
     * Save a reply.
     *
     * @param replyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ReplyDTO saveReply(ReplyDTO replyDTO) {
        log.debug("Request to save Reply : {}", replyDTO);

        Reply reply = replyMapper.toEntity(replyDTO);
        reply = replyRepository.save(reply);
        return replyMapper.toDto(reply);
    }
    
    /**
     * Delete the loved activity of the user..
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteLoveOfCommitedActivity(LoveDTO loveDto) {
        log.debug("Request to delete Love : {}", loveDto);
        loveRepository.deleteLoveOfCommitedActivityByUserIdAndCommitedActivityId(loveDto.getUserId(),loveDto.getCommitedActivityId());
        
    }
    
    /**
     * Delete the loved activity of the user..
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteLoveOfComment(LoveDTO loveDto) {
        log.debug("Request to delete Love : {}", loveDto);
        loveRepository.deleteLoveOfCommentByUserIdAndCommentId(loveDto.getUserId(),loveDto.getCommentId());
        
    }
    
    /**
     * Delete the loved activity of the user..
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteLoveOfReply(LoveDTO loveDto) {
        log.debug("Request to delete Love : {}", loveDto);
        loveRepository.deleteLoveOfReplyByUserIdAndReplyId(loveDto.getUserId(), loveDto.getReplyId());
        
    }
    
    /**
     * Delete the comment by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteComment(Long id) {
        log.debug("Request to delete Comment : {}", id);
        commentRepository.deleteById(id);
    }
    
    /**
     * Delete the reply by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteReply(Long id) {
        log.debug("Request to delete Reply : {}", id);
        replyRepository.deleteById(id);
    }

}
