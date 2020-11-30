package com.lendbox.diksha.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendbox.diksha.model.SessionDetails;
import com.lendbox.diksha.model.TaskDetails;
import com.lendbox.diksha.model.UserDetails;
import com.lendbox.diksha.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	HomeService homeService;

	@RequestMapping("/hello")
	public String hello(){
		return "HELLO";
	} 
	
	@PostMapping("/signup")
	public UserDetails signup(@RequestBody UserDetails user) throws Exception{
		return homeService.signup(user);
	}
	
	@PostMapping("/login")
	public SessionDetails login(@RequestBody UserDetails user){
		String emailid=user.getEmail();
		String pass=user.getPass();
		try{
			UserDetails u= homeService.login(emailid,pass);
			System.out.println("User valid");
			SessionDetails newSession = new SessionDetails(UUID.randomUUID().toString(), u.getId());
			return homeService.addSession(newSession);
		}
		catch(Exception e){
			System.out.println("User Invalid");
		}
		return null;
	}
	
	@PostMapping("/addTask")
	public TaskDetails addTask(@RequestBody TaskDetails task, @RequestHeader("sessionId") String sessionId) throws Exception{
		validateSession(sessionId);
		return homeService.addTask(task);
	}


	@GetMapping("/getTask")
	public List<TaskDetails> getAllTask(@RequestHeader("sessionId") String sessionId) throws Exception{
		validateSession(sessionId);
		System.out.print(sessionId);
		return homeService.getAllTask(homeService.getUserIdFromSessionId(sessionId));
	}
	
	@GetMapping("/logout")
	public void logout(@RequestHeader("sessionId") String sessionId) throws Exception{
		validateSession(sessionId);
		homeService.logout(sessionId);
	}
	
	@PostMapping("/markComplete")
	public void markComplete(@RequestHeader("taskId") String taskId, @RequestHeader("sessionId") String sessionId) throws Exception{
		validateSession(sessionId);
		homeService.markComplete(Integer.parseInt(taskId));
	}
	
	@PostMapping("/deleteTask")
	public void markComplete(@RequestHeader("taskId") Integer taskId, @RequestHeader("sessionId") String sessionId) throws Exception{
		validateSession(sessionId);
		homeService.deleteTask(taskId);
	}
	private void validateSession(String sessionId) throws Exception{
		if(sessionId == null || sessionId.isEmpty()) {
			throw new Exception("Session Id is missing");
		}
	}
	
}
