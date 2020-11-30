package com.lendbox.diksha.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lendbox.diksha.model.SessionDetails;

@Repository
public interface SessionDetailRepository extends JpaRepository<SessionDetails, Integer>{

	SessionDetails findBySessionId(String sessionId);

	@Transactional
	void deleteBySessionId(String session_id);
}
