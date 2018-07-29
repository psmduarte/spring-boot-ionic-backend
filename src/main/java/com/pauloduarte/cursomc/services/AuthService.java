package com.pauloduarte.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.repositories.ClienteRepository;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe; //pe de passwordencoder
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
		
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i]=randomChar();
		}	
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3); //random de 3 numeros (0,1 ou 2)
		if(opt == 0) { // gera digito
			return (char)(rand.nextInt(10) + 48); //gera um numero entre 48 e 58 (ver tabela unicode)
		}
		if(opt == 1) {//gera letra maiuscula
			return (char)(rand.nextInt(26)+65); 
		}
		
		else { // gera minuscula
			return(char)(rand.nextInt(26)+97);
		}
		
	}

}
