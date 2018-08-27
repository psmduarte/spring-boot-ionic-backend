package com.pauloduarte.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pauloduarte.cursomc.domain.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
	
	@Transactional(readOnly=true)
	public List<Distrito> findAllByOrderByNome();

}
