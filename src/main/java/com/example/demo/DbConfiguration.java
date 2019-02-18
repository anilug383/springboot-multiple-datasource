package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfiguration {
	
	@Bean("profileService")
	@ConfigurationProperties(prefix="spring.profileservice")
	@Primary
	public DataSource profileServicedataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("taskService")
	@ConfigurationProperties(prefix="spring.taskService")
	public DataSource taskServiceDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("profileJdbcTemplate")
	@Autowired
	public JdbcTemplate profileJdbcTemplate(@Qualifier("profileService")DataSource profileDs) {
		return new JdbcTemplate(profileDs);
	}
	
	@Bean("taskJdbcTemplate")
	@Autowired
	public JdbcTemplate taskJdbcTemplate(@Qualifier("taskService")DataSource profileDs) {
		return new JdbcTemplate(profileDs);
	}


}
