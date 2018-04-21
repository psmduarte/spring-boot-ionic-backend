package com.pauloduarte.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Pedido;
import com.pauloduarte.cursomc.repositories.PedidoRepository;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido>obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objecto não encontrado id:" + id + "Tipo: " + Pedido.class.getName()));
	}

}
