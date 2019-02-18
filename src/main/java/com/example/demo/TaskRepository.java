package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {
	
	@Autowired
	@Qualifier("taskJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public int getTaskCount() {
		return jdbcTemplate.queryForObject("select count(*) from tasks", Integer.class);
	}

}
