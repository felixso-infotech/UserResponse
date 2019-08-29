package com.felixsoinfotech.user_response.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.user_response.service.LoveService;
import com.felixsoinfotech.user_response.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.user_response.web.rest.util.HeaderUtil;
import com.felixsoinfotech.user_response.web.rest.util.PaginationUtil;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Love.
 */
@RestController
@RequestMapping("/api")
public class LoveResource {

    private final Logger log = LoggerFactory.getLogger(LoveResource.class);

    private static final String ENTITY_NAME = "userResponseLove";

    private final LoveService loveService;

    public LoveResource(LoveService loveService) {
        this.loveService = loveService;
    }

    /**
     * POST  /loves : Create a new love.
     *
     * @param loveDTO the loveDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new loveDTO, or with status 400 (Bad Request) if the love has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/loves")
    @Timed
    public ResponseEntity<LoveDTO> createLove(@RequestBody LoveDTO loveDTO) throws URISyntaxException {
        log.debug("REST request to save Love : {}", loveDTO);
        if (loveDTO.getId() != null) {
            throw new BadRequestAlertException("A new love cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LoveDTO result = loveService.save(loveDTO);
        return ResponseEntity.created(new URI("/api/loves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /loves : Updates an existing love.
     *
     * @param loveDTO the loveDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated loveDTO,
     * or with status 400 (Bad Request) if the loveDTO is not valid,
     * or with status 500 (Internal Server Error) if the loveDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/loves")
    @Timed
    public ResponseEntity<LoveDTO> updateLove(@RequestBody LoveDTO loveDTO) throws URISyntaxException {
        log.debug("REST request to update Love : {}", loveDTO);
        if (loveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        LoveDTO result = loveService.save(loveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, loveDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /loves : get all the loves.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of loves in body
     */
    @GetMapping("/loves")
    @Timed
    public ResponseEntity<List<LoveDTO>> getAllLoves(Pageable pageable) {
        log.debug("REST request to get a page of Loves");
        Page<LoveDTO> page = loveService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/loves");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /loves/:id : get the "id" love.
     *
     * @param id the id of the loveDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the loveDTO, or with status 404 (Not Found)
     */
    @GetMapping("/loves/{id}")
    @Timed
    public ResponseEntity<LoveDTO> getLove(@PathVariable Long id) {
        log.debug("REST request to get Love : {}", id);
        Optional<LoveDTO> loveDTO = loveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(loveDTO);
    }

    /**
     * DELETE  /loves/:id : delete the "id" love.
     *
     * @param id the id of the loveDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/loves/{id}")
    @Timed
    public ResponseEntity<Void> deleteLove(@PathVariable Long id) {
        log.debug("REST request to delete Love : {}", id);
        loveService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
