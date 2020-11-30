package com.lendbox.diksha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionDetails {
	@Id
	public String sessionId;
	@Column
	public int userId;
	
	public SessionDetails(){
		
	}
	public SessionDetails(String sessionId, int userId) {
		super();
		this.sessionId = sessionId;
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
