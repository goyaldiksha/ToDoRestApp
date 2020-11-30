package com.lendbox.diksha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendbox.diksha.model.SessionDetails;
import com.lendbox.diksha.model.TaskDetails;
import com.lendbox.diksha.model.UserDetails;
import com.lendbox.diksha.repository.SessionDetailRepository;
import com.lendbox.diksha.repository.TaskDetailRepository;
import com.lendbox.diksha.repository.UserDetailRepository;

@Service
public class HomeServiceImpl implements HomeService{

	//@Autowired
	//HomeDao hd;
	
	@Autowired
	TaskDetailRepository taskDetailRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	SessionDetailRepository sessionDetailRepository;
	
	@Override
	public UserDetails checkUser(UserDetails u) throws Exception {
		// TODO Auto-generated method stub
//		return hd.checkUser(u);
		return null;
	}

	@Override
	public void newProfile(UserDetails u) throws Exception {
		// TODO Auto-generated method stub
	//	hd.newProfile(u);
		
	}


	@Override
	public SessionDetails getSession(String sessionId) throws Exception {
		// TODO Auto-generated method stub
	//	return hd.getSession(sessionId);
		return null;
	}

	@Override
	public ArrayList<TaskDetails> getTask(int userId) throws Exception {
		// TODO Auto-generated method stub
		//return hd.getTask(userId);
		return null;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		//hd.delete(id);
	}

	@Override
	public void complete(int id) throws Exception {
		// TODO Auto-generated method stub
		//hd.complete(id);
	}

	
//	new methods
	@Override
	public TaskDetails addTask(TaskDetails task) throws Exception {
		// TODO Auto-generated method stub
		return taskDetailRepository.save(task);
		//return taskDetailRepository.addTask(u.getUserId(), u.getName(), u.getDate(), u.getCompleted());
	}

	@Override
	public UserDetails signup(UserDetails user) throws Exception{
		// TODO Auto-generated method stub
		return userDetailRepository.save(user);
	}
	
	@Override
	public List<TaskDetails> getAllTask(Integer userId) {
		// TODO Auto-generated method stub
		return taskDetailRepository.findByUserId(userId);
	}

	@Override
	public UserDetails login(String email, String pass) throws Exception{
		// TODO Auto-generated method stub
		return userDetailRepository.findByEmailAddress(email, pass);
	}

	@Override
	public SessionDetails addSession(SessionDetails session) throws Exception {
		// TODO Auto-generated method stub
		return sessionDetailRepository.save(session);
	}

	@Override
	public Integer getUserIdFromSessionId(String sessionId) {
		SessionDetails session = sessionDetailRepository.findBySessionId(sessionId);	
		return session.getUserId();
	}
	
	@Override
	public void logout(String session_id) throws Exception {
		// TODO Auto-generated method stub
		sessionDetailRepository.deleteBySessionId(session_id);
	}

	@Override
	public void markComplete(Integer taskId) throws Exception{
		// TODO Auto-generated method stub
		Integer completed=1;
		taskDetailRepository.updateCompletedTask(completed, taskId);
	}

	@Override
	public void deleteTask(Integer taskId) throws Exception{
		// TODO Auto-generated method stub
		taskDetailRepository.deleteById(taskId);
	}

}
