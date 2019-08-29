package com.felixsoinfotech.user_response.repository;

import com.felixsoinfotech.user_response.domain.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//Page<Comment> findAllCommentsByCommitedActivityId(Pageable pageable,Long commitedActivityId);
}
