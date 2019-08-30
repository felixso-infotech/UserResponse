package com.felixsoinfotech.user_response.repository;

import com.felixsoinfotech.user_response.domain.Love;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Love entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LoveRepository extends JpaRepository<Love, Long> {

	void deleteByUserIdAndCommitedActivityId(String userId, Long commitedActivityId);
	
	@Query(value = "select count(l) from Love l where l.commitedActivityId=:commitedActivityId")
	Long findNumberOfLovesByCommitedActivityId(@Param("commitedActivityId") Long commitedActivityId);
	
	@Query(value = "select count(l) from Love l where l.comment.id=:commentId")
	Long findNumberOfLovesByCommentId(@Param("commentId") Long commentId);
	
	@Query(value = "select count(l) from Love l where l.reply.id=:replyId")
	Long findNumberOfLovesByReplyId(@Param("replyId") Long replyId);
    
}
