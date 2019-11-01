package com.felixsoinfotech.user_response.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.user_response.model.DeleteLoveModel;
import com.felixsoinfotech.user_response.service.AggregateCommandService;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.user_response.web.rest.util.HeaderUtil;

/**
 * REST controller for managing user response commands.
 */
@RestController
@RequestMapping("/api/command")
public class UserResponseAggregateCommandResource {

	private final Logger log = LoggerFactory.getLogger(UserResponseAggregateCommandResource.class);

	private static final String ENTITY_NAME = "userResponseAggregateCommandResource";
	
	@Autowired
	private AggregateCommandService AggregateCommandService;

	/**
     * POST  /loves : save a new love.
     *
     * @param loveDTO the loveDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new loveDTO, or with status 400 (Bad Request) if the love has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/love-committedactivity")
    @Timed
    public ResponseEntity<LoveDTO> loveCommittedActivity(@RequestBody LoveDTO loveDTO) throws URISyntaxException {
        log.debug("REST request to save Love : {}", loveDTO);
        if (loveDTO.getId() != null) {
            throw new BadRequestAlertException("A new love cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LoveDTO result = AggregateCommandService.saveLove(loveDTO);
        return ResponseEntity.created(new URI("/api/command/love-activity/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * POST  /comments : save a new comment.
     *
     * @param commentDTO the commentDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new commentDTO, or with status 400 (Bad Request) if the comment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/save-comment")
    @Timed
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO) throws URISyntaxException {
        log.debug("REST request to save Comment : {}", commentDTO);
        if (commentDTO.getId() != null) {
            throw new BadRequestAlertException("A new comment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommentDTO result = AggregateCommandService.saveComment(commentDTO);
        return ResponseEntity.created(new URI("/api/command/save-comment/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * POST  /replies : Create a new reply.
     *
     * @param replyDTO the replyDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new replyDTO, or with status 400 (Bad Request) if the reply has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/save-reply")
    @Timed
    public ResponseEntity<ReplyDTO> saveReply(@RequestBody ReplyDTO replyDTO) throws URISyntaxException {
        log.debug("REST request to save Reply : {}", replyDTO);
        if (replyDTO.getId() != null) {
            throw new BadRequestAlertException("A new reply cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReplyDTO result = AggregateCommandService.saveReply(replyDTO);
        return ResponseEntity.created(new URI("/api/command/save-reply/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * DELETE  /loves : delete the loved activity of the user.
     *
     * @param deleteLoveModel the deleteLoveModel of the loveDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/unlove-committedactivity")
    @Timed
    public ResponseEntity<Void> unloveCommittedActivity(@RequestBody DeleteLoveModel deleteLoveModel) {
        log.debug("REST request to delete Love activity of the user : {}", deleteLoveModel);
        AggregateCommandService.deleteLove(deleteLoveModel);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, deleteLoveModel.toString())).build();
    }

    /**
     * DELETE  /comments : delete the "id" comment.
     *
     * @param id the id of the commentDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete-comment/{id}")
    @Timed
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        log.debug("REST request to delete Comment : {}", id);
        AggregateCommandService.deleteComment(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * DELETE  /replies/:id : delete the "id" reply.
     *
     * @param id the id of the replyDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete-reply/{id}")
    @Timed
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        log.debug("REST request to delete Reply : {}", id);
        AggregateCommandService.deleteReply(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
    
}
