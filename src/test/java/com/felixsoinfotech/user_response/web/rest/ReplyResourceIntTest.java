package com.felixsoinfotech.user_response.web.rest;

import com.felixsoinfotech.user_response.UserResponseApp;

import com.felixsoinfotech.user_response.domain.Reply;
import com.felixsoinfotech.user_response.repository.ReplyRepository;
import com.felixsoinfotech.user_response.service.ReplyService;
import com.felixsoinfotech.user_response.service.dto.ReplyDTO;
import com.felixsoinfotech.user_response.service.mapper.ReplyMapper;
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
 * Test class for the ReplyResource REST controller.
 *
 * @see ReplyResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserResponseApp.class)
public class ReplyResourceIntTest {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_USER_ID = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_DATE_AND_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DATE_AND_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restReplyMockMvc;

    private Reply reply;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReplyResource replyResource = new ReplyResource(replyService);
        this.restReplyMockMvc = MockMvcBuilders.standaloneSetup(replyResource)
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
    public static Reply createEntity(EntityManager em) {
        Reply reply = new Reply()
            .description(DEFAULT_DESCRIPTION)
            .userId(DEFAULT_USER_ID)
            .dateAndTime(DEFAULT_DATE_AND_TIME);
        return reply;
    }

    @Before
    public void initTest() {
        reply = createEntity(em);
    }

    @Test
    @Transactional
    public void createReply() throws Exception {
        int databaseSizeBeforeCreate = replyRepository.findAll().size();

        // Create the Reply
        ReplyDTO replyDTO = replyMapper.toDto(reply);
        restReplyMockMvc.perform(post("/api/replies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isCreated());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeCreate + 1);
        Reply testReply = replyList.get(replyList.size() - 1);
        assertThat(testReply.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testReply.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testReply.getDateAndTime()).isEqualTo(DEFAULT_DATE_AND_TIME);
    }

    @Test
    @Transactional
    public void createReplyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = replyRepository.findAll().size();

        // Create the Reply with an existing ID
        reply.setId(1L);
        ReplyDTO replyDTO = replyMapper.toDto(reply);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReplyMockMvc.perform(post("/api/replies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllReplies() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        // Get all the replyList
        restReplyMockMvc.perform(get("/api/replies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reply.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].dateAndTime").value(hasItem(sameInstant(DEFAULT_DATE_AND_TIME))));
    }
    
    @Test
    @Transactional
    public void getReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        // Get the reply
        restReplyMockMvc.perform(get("/api/replies/{id}", reply.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reply.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.dateAndTime").value(sameInstant(DEFAULT_DATE_AND_TIME)));
    }

    @Test
    @Transactional
    public void getNonExistingReply() throws Exception {
        // Get the reply
        restReplyMockMvc.perform(get("/api/replies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        int databaseSizeBeforeUpdate = replyRepository.findAll().size();

        // Update the reply
        Reply updatedReply = replyRepository.findById(reply.getId()).get();
        // Disconnect from session so that the updates on updatedReply are not directly saved in db
        em.detach(updatedReply);
        updatedReply
            .description(UPDATED_DESCRIPTION)
            .userId(UPDATED_USER_ID)
            .dateAndTime(UPDATED_DATE_AND_TIME);
        ReplyDTO replyDTO = replyMapper.toDto(updatedReply);

        restReplyMockMvc.perform(put("/api/replies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isOk());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeUpdate);
        Reply testReply = replyList.get(replyList.size() - 1);
        assertThat(testReply.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReply.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testReply.getDateAndTime()).isEqualTo(UPDATED_DATE_AND_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingReply() throws Exception {
        int databaseSizeBeforeUpdate = replyRepository.findAll().size();

        // Create the Reply
        ReplyDTO replyDTO = replyMapper.toDto(reply);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReplyMockMvc.perform(put("/api/replies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        int databaseSizeBeforeDelete = replyRepository.findAll().size();

        // Get the reply
        restReplyMockMvc.perform(delete("/api/replies/{id}", reply.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Reply.class);
        Reply reply1 = new Reply();
        reply1.setId(1L);
        Reply reply2 = new Reply();
        reply2.setId(reply1.getId());
        assertThat(reply1).isEqualTo(reply2);
        reply2.setId(2L);
        assertThat(reply1).isNotEqualTo(reply2);
        reply1.setId(null);
        assertThat(reply1).isNotEqualTo(reply2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReplyDTO.class);
        ReplyDTO replyDTO1 = new ReplyDTO();
        replyDTO1.setId(1L);
        ReplyDTO replyDTO2 = new ReplyDTO();
        assertThat(replyDTO1).isNotEqualTo(replyDTO2);
        replyDTO2.setId(replyDTO1.getId());
        assertThat(replyDTO1).isEqualTo(replyDTO2);
        replyDTO2.setId(2L);
        assertThat(replyDTO1).isNotEqualTo(replyDTO2);
        replyDTO1.setId(null);
        assertThat(replyDTO1).isNotEqualTo(replyDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(replyMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(replyMapper.fromId(null)).isNull();
    }
}
