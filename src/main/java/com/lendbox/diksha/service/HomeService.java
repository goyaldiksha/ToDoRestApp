package com.lendbox.diksha.service;

import java.util.ArrayList;
import java.util.List;

import com.lendbox.diksha.model.SessionDetails;
import com.lendbox.diksha.model.TaskDetails;
import com.lendbox.diksha.model.UserDetails;

public interface HomeService {

	UserDetails checkUser(UserDetails u) throws Exception;

	void newProfile(UserDetails u) throws Exception;

	TaskDetails addTask(TaskDetails u) throws Exception;
	
	ArrayList<TaskDetails> getTask(int userId) throws Exception;
	
	SessionDetails addSession(SessionDetails u) throws Exception;
	
	SessionDetails getSession(String sessionId) throws Exception;

	void logout(String sessionId) throws Exception;

	void delete(int id) throws Exception;

	void complete(int id) throws Exception;

	List<TaskDetails> getAllTask(Integer userId);

	UserDetails signup(UserDetails user) throws Exception;

	UserDetails login(String id, String pass) throws Exception;

	Integer getUserIdFromSessionId(String sessionId);

	void markComplete(Integer taskId) throws Exception;

	void deleteTask(Integer taskId) throws Exception;

}
