package com.felixsoinfotech.user_response.web.rest;

import java.util.List;

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
import com.felixsoinfotech.user_response.web.rest.util.PaginationUtil;
import com.felixsoinfotech.user_response.service.AggregateQueryService;

/**
 * REST controller for managing user response queries.
 */
@RestController
@RequestMapping("/api")
public class AggregateQueryResource {

	private final Logger log = LoggerFactory.getLogger(AggregateQueryResource.class);

	private static final String ENTITY_NAME = "userResponseAggregateQueryResource";

	/*@Autowired
	private AggregateQueryService AggregateQueryService;
	
	*//**
     * GET  /comments : get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrive comments,pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of comments in body
     *//*
    @GetMapping("/query/get-comments-by-commitedActivityId/{commitedActivityId}")
    @Timed
    public ResponseEntity<List<CommentDTO>> getAllCommentsByCommitedActivityId(Pageable pageable,@PathVariable Long commitedActivityId) {
        log.debug("REST request to get a page of Comments");
        Page<CommentDTO> page = AggregateQueryService.findAllCommentsByCommitedActivityId(pageable,commitedActivityId);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/query/get-comments-by-commitedActivityId/{commitedActivityId}");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    *//**
     * GET  /comments : get all the comments by commitedActivityId.
     *
     * @param commitedActivityId the activity id to retrive comments,pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of comments in body
     *//*
    @GetMapping("/query/numberofcomments-by-commitedActivityId/{commitedActivityId}")
    @Timed
    public ResponseEntity<List<CommentDTO>> getNumberOfCommentsByCommitedActivityId(Pageable pageable,@PathVariable Long commitedActivityId) {
        log.debug("REST request to get a page of Comments");
        Page<CommentDTO> page = AggregateQueryService.findAllCommentsByCommitedActivityId(pageable,commitedActivityId);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/query/get-comments-by-commitedActivityId/{commitedActivityId}");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }*/
    
}

