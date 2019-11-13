package com.felixsoinfotech.user_response.service;


import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;

/**
 * Service Interface for managing user response service.
 */
public interface AggregateCommandService {

	 /**
     * Save a love.
     *
     * @param loveDTO the entity to save
     * @return the persisted entity
     */
    LoveDTO saveLove(LoveDTO loveDTO);
    
    /**
     * Save a comment.
     *
     * @param commentDTO the entity to save
     * @return the persisted entity
     */
    CommentDTO saveComment(CommentDTO commentDTO);


    /**
     * Save a reply.
     *
     * @param replyDTO the entity to save
     * @return the persisted entity
     */
    ReplyDTO saveReply(ReplyDTO replyDTO);
    
    /**
     * Delete the loved activity of the user.
     *
     * @param id the id of the entity
     */
    void deleteLoveOfCommitedActivity(LoveDTO loveDto);
    
    /**
     * Delete the loved activity of the user.
     *
     * @param id the id of the entity
     */
    void deleteLoveOfComment(LoveDTO loveDto);
    
    /**
     * Delete the loved activity of the user.
     *
     * @param id the id of the entity
     */
    void deleteLoveOfReply(LoveDTO loveDto);
    
    
    /**
     * Delete the "id" comment.
     *
     * @param id the id of the entity
     */
    void deleteComment(Long id);
    
    /**
     * Delete the "id" reply.
     *
     * @param id the id of the entity
     */
    void deleteReply(Long id);
    
    
}
