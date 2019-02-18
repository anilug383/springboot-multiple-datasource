package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbRestController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/getUserCount")
	public int userCount() {
		return profileRepository.getUserCount();
	}
	
	@GetMapping("/getTaskcount")
	public int getTask() {
		return taskRepository.getTaskCount();
	}

}
