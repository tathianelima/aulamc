package com.cursojava.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.services.DBService;
import com.cursojava.services.EmailService;
import com.cursojava.services.SmtpEmailService;



@Configuration
@Profile("dev")
public class DevConfig {
	

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	@Bean
	public boolean instanceDatabase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instanciateTestDatabase();
		
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
