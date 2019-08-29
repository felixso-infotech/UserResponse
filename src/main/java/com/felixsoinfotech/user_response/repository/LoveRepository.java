package com.felixsoinfotech.user_response.repository;

import com.felixsoinfotech.user_response.domain.Love;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Love entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LoveRepository extends JpaRepository<Love, Long> {

	void deleteByUserIdAndCommitedActivityId(String userId, Long commitedActivityId);
    
}
