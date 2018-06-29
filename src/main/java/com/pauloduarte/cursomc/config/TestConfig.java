package com.pauloduarte.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pauloduarte.cursomc.services.DBService;
import com.pauloduarte.cursomc.services.EmailService;
import com.pauloduarte.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbSevice;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbSevice.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
	return new MockEmailService();
	}

}
