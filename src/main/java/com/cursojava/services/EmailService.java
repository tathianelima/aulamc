package com.cursojava.services;

import org.springframework.mail.SimpleMailMessage;

import com.cursojava.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
