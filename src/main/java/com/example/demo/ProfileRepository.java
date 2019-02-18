package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
	
	@Autowired
	@Qualifier("profileJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public int getUserCount() {
		return jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}

}
