package com.felixsoinfotech.user_response.web.rest;

import com.felixsoinfotech.user_response.UserResponseApp;

import com.felixsoinfotech.user_response.domain.Love;
import com.felixsoinfotech.user_response.repository.LoveRepository;
import com.felixsoinfotech.user_response.service.LoveService;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;
import com.felixsoinfotech.user_response.service.mapper.LoveMapper;
import com.felixsoinfotech.user_response.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;


import static com.felixsoinfotech.user_response.web.rest.TestUtil.sameInstant;
import static com.felixsoinfotech.user_response.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the LoveResource REST controller.
 *
 * @see LoveResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserResponseApp.class)
public class LoveResourceIntTest {

    private static final String DEFAULT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_USER_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_COMMITED_ACTIVITY_ID = 1L;
    private static final Long UPDATED_COMMITED_ACTIVITY_ID = 2L;

    private static final Long DEFAULT_COMPLETED_CHALLENGE_ID = 1L;
    private static final Long UPDATED_COMPLETED_CHALLENGE_ID = 2L;

    private static final ZonedDateTime DEFAULT_DATE_AND_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DATE_AND_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private LoveRepository loveRepository;

    @Autowired
    private LoveMapper loveMapper;

    @Autowired
    private LoveService loveService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restLoveMockMvc;

    private Love love;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final LoveResource loveResource = new LoveResource(loveService);
        this.restLoveMockMvc = MockMvcBuilders.standaloneSetup(loveResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Love createEntity(EntityManager em) {
        Love love = new Love()
            .userId(DEFAULT_USER_ID)
            .commitedActivityId(DEFAULT_COMMITED_ACTIVITY_ID)
            .completedChallengeId(DEFAULT_COMPLETED_CHALLENGE_ID)
            .dateAndTime(DEFAULT_DATE_AND_TIME);
        return love;
    }

    @Before
    public void initTest() {
        love = createEntity(em);
    }

    @Test
    @Transactional
    public void createLove() throws Exception {
        int databaseSizeBeforeCreate = loveRepository.findAll().size();

        // Create the Love
        LoveDTO loveDTO = loveMapper.toDto(love);
        restLoveMockMvc.perform(post("/api/loves")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(loveDTO)))
            .andExpect(status().isCreated());

        // Validate the Love in the database
        List<Love> loveList = loveRepository.findAll();
        assertThat(loveList).hasSize(databaseSizeBeforeCreate + 1);
        Love testLove = loveList.get(loveList.size() - 1);
        assertThat(testLove.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testLove.getCommitedActivityId()).isEqualTo(DEFAULT_COMMITED_ACTIVITY_ID);
        assertThat(testLove.getCompletedChallengeId()).isEqualTo(DEFAULT_COMPLETED_CHALLENGE_ID);
        assertThat(testLove.getDateAndTime()).isEqualTo(DEFAULT_DATE_AND_TIME);
    }

    @Test
    @Transactional
    public void createLoveWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = loveRepository.findAll().size();

        // Create the Love with an existing ID
        love.setId(1L);
        LoveDTO loveDTO = loveMapper.toDto(love);

        // An entity with an existing ID cannot be created, so this API call must fail
        restLoveMockMvc.perform(post("/api/loves")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(loveDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Love in the database
        List<Love> loveList = loveRepository.findAll();
        assertThat(loveList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllLoves() throws Exception {
        // Initialize the database
        loveRepository.saveAndFlush(love);

        // Get all the loveList
        restLoveMockMvc.perform(get("/api/loves?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(love.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].commitedActivityId").value(hasItem(DEFAULT_COMMITED_ACTIVITY_ID.intValue())))
            .andExpect(jsonPath("$.[*].completedChallengeId").value(hasItem(DEFAULT_COMPLETED_CHALLENGE_ID.intValue())))
            .andExpect(jsonPath("$.[*].dateAndTime").value(hasItem(sameInstant(DEFAULT_DATE_AND_TIME))));
    }
    
    @Test
    @Transactional
    public void getLove() throws Exception {
        // Initialize the database
        loveRepository.saveAndFlush(love);

        // Get the love
        restLoveMockMvc.perform(get("/api/loves/{id}", love.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(love.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.commitedActivityId").value(DEFAULT_COMMITED_ACTIVITY_ID.intValue()))
            .andExpect(jsonPath("$.completedChallengeId").value(DEFAULT_COMPLETED_CHALLENGE_ID.intValue()))
            .andExpect(jsonPath("$.dateAndTime").value(sameInstant(DEFAULT_DATE_AND_TIME)));
    }

    @Test
    @Transactional
    public void getNonExistingLove() throws Exception {
        // Get the love
        restLoveMockMvc.perform(get("/api/loves/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateLove() throws Exception {
        // Initialize the database
        loveRepository.saveAndFlush(love);

        int databaseSizeBeforeUpdate = loveRepository.findAll().size();

        // Update the love
        Love updatedLove = loveRepository.findById(love.getId()).get();
        // Disconnect from session so that the updates on updatedLove are not directly saved in db
        em.detach(updatedLove);
        updatedLove
            .userId(UPDATED_USER_ID)
            .commitedActivityId(UPDATED_COMMITED_ACTIVITY_ID)
            .completedChallengeId(UPDATED_COMPLETED_CHALLENGE_ID)
            .dateAndTime(UPDATED_DATE_AND_TIME);
        LoveDTO loveDTO = loveMapper.toDto(updatedLove);

        restLoveMockMvc.perform(put("/api/loves")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(loveDTO)))
            .andExpect(status().isOk());

        // Validate the Love in the database
        List<Love> loveList = loveRepository.findAll();
        assertThat(loveList).hasSize(databaseSizeBeforeUpdate);
        Love testLove = loveList.get(loveList.size() - 1);
        assertThat(testLove.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testLove.getCommitedActivityId()).isEqualTo(UPDATED_COMMITED_ACTIVITY_ID);
        assertThat(testLove.getCompletedChallengeId()).isEqualTo(UPDATED_COMPLETED_CHALLENGE_ID);
        assertThat(testLove.getDateAndTime()).isEqualTo(UPDATED_DATE_AND_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingLove() throws Exception {
        int databaseSizeBeforeUpdate = loveRepository.findAll().size();

        // Create the Love
        LoveDTO loveDTO = loveMapper.toDto(love);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restLoveMockMvc.perform(put("/api/loves")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(loveDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Love in the database
        List<Love> loveList = loveRepository.findAll();
        assertThat(loveList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteLove() throws Exception {
        // Initialize the database
        loveRepository.saveAndFlush(love);

        int databaseSizeBeforeDelete = loveRepository.findAll().size();

        // Get the love
        restLoveMockMvc.perform(delete("/api/loves/{id}", love.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Love> loveList = loveRepository.findAll();
        assertThat(loveList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Love.class);
        Love love1 = new Love();
        love1.setId(1L);
        Love love2 = new Love();
        love2.setId(love1.getId());
        assertThat(love1).isEqualTo(love2);
        love2.setId(2L);
        assertThat(love1).isNotEqualTo(love2);
        love1.setId(null);
        assertThat(love1).isNotEqualTo(love2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(LoveDTO.class);
        LoveDTO loveDTO1 = new LoveDTO();
        loveDTO1.setId(1L);
        LoveDTO loveDTO2 = new LoveDTO();
        assertThat(loveDTO1).isNotEqualTo(loveDTO2);
        loveDTO2.setId(loveDTO1.getId());
        assertThat(loveDTO1).isEqualTo(loveDTO2);
        loveDTO2.setId(2L);
        assertThat(loveDTO1).isNotEqualTo(loveDTO2);
        loveDTO1.setId(null);
        assertThat(loveDTO1).isNotEqualTo(loveDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(loveMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(loveMapper.fromId(null)).isNull();
    }
}
