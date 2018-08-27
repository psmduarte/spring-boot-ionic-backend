package com.pauloduarte.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Distrito;
import com.pauloduarte.cursomc.repositories.DistritoRepository;

@Service
public class DistritoService {
	
	@Autowired
	private DistritoRepository repo;
	
	public List<Distrito> findAll(){
		return repo.findAllByOrderByNome();
	}

}
