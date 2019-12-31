package com.felixsoinfotech.user_response.repository;

import com.felixsoinfotech.user_response.domain.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	Page<Comment> findAllCommentsByCommitedActivityIdOrderByDateAndTimeDesc(Pageable pageable,Long commitedActivityId);
	
	@Query(value = "select count(c) from Comment c where c.commitedActivityId=:commitedActivityId")
	Long findNumberOfCommentsByCommitedActivityId(@Param("commitedActivityId") Long commitedActivityId);
	
	
}
