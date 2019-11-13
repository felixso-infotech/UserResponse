package com.felixsoinfotech.user_response.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.user_response.model.CommentAggregate;
import com.felixsoinfotech.user_response.model.CountAggregate;
import com.felixsoinfotech.user_response.model.ReplyAggregate;
import com.felixsoinfotech.user_response.repository.CommentRepository;
import com.felixsoinfotech.user_response.repository.LoveRepository;
import com.felixsoinfotech.user_response.repository.ReplyRepository;
import com.felixsoinfotech.user_response.service.AggregateQueryService;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.service.mapper.CommentMapper;
import com.felixsoinfotech.user_response.service.mapper.LoveMapper;
import com.felixsoinfotech.user_response.service.mapper.ReplyMapper;


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
     * Get CountAggregate.
     *
     * @param commitedActivityId the commitedActivityId of the entity
     * @return the entity
     */
	@Override
	public Optional<CountAggregate> findCountOfCommentsAndLikesByCommitedActivityId(Long commitedActivityId) {
		
		CountAggregate countAggregate= new CountAggregate();
		
		countAggregate.setNoOfLoves(loveRepository.findNumberOfLovesByCommitedActivityId(commitedActivityId));
		countAggregate.setNoOfComments(commentRepository.findNumberOfCommentsByCommitedActivityId(commitedActivityId));
		
		return Optional.of(countAggregate);		
		
	}
    
	

	/**
     * Get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrieve comments,pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommentAggregate> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId) {
        log.debug("Request to get all Comments by commitedActivityId");
        
         List<CommentAggregate>  commentAggregateList=new ArrayList<CommentAggregate>();
         
         CommentAggregate commentAggregate;
        
         Page<CommentDTO> commentDTOs=commentRepository.findAllCommentsByCommitedActivityId(pageable,commitedActivityId).map(commentMapper::toDto);
         for(CommentDTO commentDTO :commentDTOs.getContent())
         {
        	 commentAggregate=new CommentAggregate();
        	 
        	 if(commentDTO != null)
        	 {        		 
        	 commentAggregate.setCommentId(commentDTO.getId());
        	 commentAggregate.setDescription(commentDTO.getDescription());
        	 commentAggregate.setCompletedChallengeId(commentDTO.getCompletedChallengeId());
        	 commentAggregate.setCommitedActivityId(commentDTO.getCommitedActivityId());
        	 commentAggregate.setCreatedDate(commentDTO.getDateAndTime());
        	 
        	     if(commentDTO.getId() != null)
        	      {
        	      commentAggregate.setNoOfLoves(loveRepository.findNumberOfLovesByCommentId(commentDTO.getId()));     	 
          	      commentAggregate.setNoOfReplies(replyRepository.findNumberOfRepliesByCommentId(commentDTO.getId()));
          	      
          	         if(commentDTO.getUserId() != null)
          	            commentAggregate.setLiked(loveRepository.isLikedCommentByUser(commentDTO.getId(),commentDTO.getUserId()));          	      
        	      }
        	 }      	 
        	 commentAggregateList.add(commentAggregate);        	 
         }
         
         Page<CommentAggregate> pagee = new PageImpl<CommentAggregate>(commentAggregateList, pageable, commentAggregateList.size());

 		 return pagee;
    }
    
    /**
     * Get all the replies by commentId.
     *
     * @param commentId the commentId to retrieve replies,pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReplyAggregate> findAllRepliesByCommentId(Pageable pageable,Long commentId) {
    	
        log.debug("Request to get all Replies by comment id");
        
        List<ReplyAggregate> replyAggregateList=new ArrayList<ReplyAggregate>();
        ReplyAggregate replyAggregate;
        
        Page<ReplyDTO> replyDtos=replyRepository.findAllRepliesByCommentId(pageable,commentId).map(replyMapper::toDto);
                
        for(ReplyDTO replyDTO : replyDtos.getContent())
        {
        	replyAggregate= new ReplyAggregate();
        	
        	if(replyDTO != null)
        	{
        		replyAggregate.setReplyId(replyDTO.getId());
        		replyAggregate.setCommentId(replyDTO.getCommentId());
        		replyAggregate.setDescription(replyDTO.getDescription());
        		replyAggregate.setDateAndTime(replyDTO.getDateAndTime());
        		replyAggregate.setUserId(replyDTO.getUserId());
        		
        		if(replyDTO.getId() != null)
        		{
        			
        		   if(replyDTO.getUserId() != null)
        		   replyAggregate.setLiked(loveRepository.isLikedReplyByUser(replyDTO.getId(), replyDTO.getUserId()));
        		
        		replyAggregate.setNoOfLoves(loveRepository.findNumberOfLovesByReplyId(replyDTO.getId()));
        		}
        	}
        	
        	replyAggregateList.add(replyAggregate);
        	
        }
        
        Page<ReplyAggregate> pagee = new PageImpl<ReplyAggregate>(replyAggregateList, pageable, replyAggregateList.size());

	    return pagee;
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


    /**
	 * @param commitedActivityId
	 * @param userId
	 * @return
	 */
	@Override
	public Boolean isLikedCommittedActivityByUser(Long commitedActivityId, String userId) {		
		log.debug("REST request to isliked committed activity by user");
		return loveRepository.isLikedCommittedActivityByUser(commitedActivityId, userId);
	}

	

}
