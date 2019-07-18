package com.cursojava.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.cursojava.domain.Pedido;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}") // para corresponder ao atributo de properties
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código:" + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis())); // System.currentTimeMillis() - usa a data do servidor
		sm.setText(obj.toString());
		return sm;
	}

}
