package com.felixsoinfotech.user_response.service.impl;

import com.felixsoinfotech.user_response.service.LoveService;
import com.felixsoinfotech.user_response.domain.Love;
import com.felixsoinfotech.user_response.repository.LoveRepository;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.mapper.LoveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Love.
 */
@Service
@Transactional
public class LoveServiceImpl implements LoveService {

    private final Logger log = LoggerFactory.getLogger(LoveServiceImpl.class);

    private final LoveRepository loveRepository;

    private final LoveMapper loveMapper;

    public LoveServiceImpl(LoveRepository loveRepository, LoveMapper loveMapper) {
        this.loveRepository = loveRepository;
        this.loveMapper = loveMapper;
    }

    /**
     * Save a love.
     *
     * @param loveDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public LoveDTO save(LoveDTO loveDTO) {
        log.debug("Request to save Love : {}", loveDTO);

        Love love = loveMapper.toEntity(loveDTO);
        love = loveRepository.save(love);
        return loveMapper.toDto(love);
    }

    /**
     * Get all the loves.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LoveDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Loves");
        return loveRepository.findAll(pageable)
            .map(loveMapper::toDto);
    }


    /**
     * Get one love by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LoveDTO> findOne(Long id) {
        log.debug("Request to get Love : {}", id);
        return loveRepository.findById(id)
            .map(loveMapper::toDto);
    }

    /**
     * Delete the love by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Love : {}", id);
        loveRepository.deleteById(id);
    }
}
