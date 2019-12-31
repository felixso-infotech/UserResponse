package com.felixsoinfotech.user_response.repository;

import com.felixsoinfotech.user_response.domain.Comment;
import com.felixsoinfotech.user_response.domain.Reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Reply entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

	Page<Reply> findAllRepliesByCommentIdOrderByDateAndTimeDesc(Pageable pageable,Long commentId);
	
	@Query(value = "select count(r) from Reply r where r.comment.id=:commentId")
	Long findNumberOfRepliesByCommentId(@Param("commentId") Long commentId);
	
	

}
