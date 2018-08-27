package com.pauloduarte.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByDistrito(Integer distrito_id){
		return repo.findCidades(distrito_id);
	}

}
