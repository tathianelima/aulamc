package com.cursojava.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.services.DBService;
import com.cursojava.services.EmailService;
import com.cursojava.services.MockEmailService;



@Configuration
@Profile("test")
public class TestConfig {
	

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanceDatabase() throws ParseException {
		dbService.instanciateTestDatabase();
		
		return true;
	}
	
	@Bean //funciona como um componente. qunado o spring encontra um autowired(injeção de dependencia), ele verifica se há componentes relacionados
	public EmailService emailService() {
		return new MockEmailService();
	}

}
