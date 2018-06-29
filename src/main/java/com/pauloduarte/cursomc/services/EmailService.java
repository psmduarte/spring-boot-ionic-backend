package com.pauloduarte.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pauloduarte.cursomc.domain.Pedido;


public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}