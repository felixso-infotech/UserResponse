package com.felixsoinfotech.user_response.service;

import com.felixsoinfotech.user_response.service.dto.LoveDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Love.
 */
public interface LoveService {

    /**
     * Save a love.
     *
     * @param loveDTO the entity to save
     * @return the persisted entity
     */
    LoveDTO save(LoveDTO loveDTO);

    /**
     * Get all the loves.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<LoveDTO> findAll(Pageable pageable);


    /**
     * Get the "id" love.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<LoveDTO> findOne(Long id);

    /**
     * Delete the "id" love.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
