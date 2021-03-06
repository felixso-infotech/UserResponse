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

	void deleteLoveOfCommitedActivityByUserIdAndCommitedActivityId(String userId, Long commitedActivityId);
	
	void deleteLoveOfCommentByUserIdAndCommentId(String userId, Long commentId);
	
	void deleteLoveOfReplyByUserIdAndReplyId(String userId, Long ReplyId);
	
	/**
	 * @param id
	 * @return
	 */
	@Query(value = "select count(l) from Love l where l.userId=:userId")
	Long findNumberOfLovesByUserId(@Param("userId") String userId);
	
	@Query(value = "select count(l) from Love l where l.commitedActivityId=:commitedActivityId")
	Long findNumberOfLovesByCommitedActivityId(@Param("commitedActivityId") Long commitedActivityId);
	
	@Query(value = "select count(l) from Love l where l.comment.id=:commentId")
	Long findNumberOfLovesByCommentId(@Param("commentId") Long commentId);
	
	@Query(value = "select count(l) from Love l where l.reply.id=:replyId")
	Long findNumberOfLovesByReplyId(@Param("replyId") Long replyId);
		
	@Query("SELECT CASE WHEN count(l) > 0 THEN true ELSE false END FROM Love l where l.commitedActivityId=:commitedActivityId and l.userId=:userId")
    Boolean isLikedCommittedActivityByUser(@Param("commitedActivityId")Long commitedActivityId,@Param("userId") String userId);

	@Query("SELECT CASE WHEN count(l) > 0 THEN true ELSE false END FROM Love l where l.comment.id=:commentId and l.userId=:userId")
    Boolean isLikedCommentByUser(@Param("commentId")Long commentId,@Param("userId") String userId);
	
	@Query("SELECT CASE WHEN count(l) > 0 THEN true ELSE false END FROM Love l where l.reply.id=:replyId and l.userId=:userId")
    Boolean isLikedReplyByUser(@Param("replyId") Long replyId,@Param("userId") String userId);
	
	
}
