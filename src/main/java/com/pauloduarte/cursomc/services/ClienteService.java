package com.pauloduarte.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.repositories.ClienteRepository;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente>obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objecto não encontrado id:" + id + "Tipo: " + Cliente.class.getName()));
	}

}
