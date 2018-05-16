package com.pauloduarte.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Produto;
import com.pauloduarte.cursomc.repositories.ProdutoRepository;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {					
		Produto obj = repo.findOne(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objecto não encontrado: " + id 
					+ "Tipo: " + Produto.class.getName());
		}
		return obj;
	}
}
