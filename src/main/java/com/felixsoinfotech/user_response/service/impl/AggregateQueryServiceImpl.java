package com.felixsoinfotech.user_response.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.user_response.repository.CommentRepository;
import com.felixsoinfotech.user_response.service.AggregateQueryService;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.mapper.CommentMapper;
import com.felixsoinfotech.user_response.web.rest.AggregateQueryResource;

/**
 * Service Implementation for managing queries in user response service.
 */
@Service
@Transactional
public class AggregateQueryServiceImpl implements AggregateQueryService {
	
	private final Logger log = LoggerFactory.getLogger(AggregateQueryServiceImpl.class);
	
	/*@Autowired
    private CommentRepository commentRepository;

	@Autowired
    private CommentMapper commentMapper;


	*//**
     * Get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrive comments,pageable the pagination information
     * @return the list of entities
     *//*
    @Override
    @Transactional(readOnly = true)
    public Page<CommentDTO> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId) {
        log.debug("Request to get all Comments by commitedActivityId");
        return commentRepository.findAllCommentsByCommitedActivityId(pageable,commitedActivityId)
            .map(commentMapper::toDto);
    }*/
    
}
