package com.pauloduarte.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pauloduarte.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbSevice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String stategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(stategy)) {
			return false;
		}
		
		dbSevice.instantiateTestDatabase();
		return true;
	}

}
