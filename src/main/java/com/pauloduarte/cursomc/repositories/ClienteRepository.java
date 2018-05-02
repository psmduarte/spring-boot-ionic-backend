package com.pauloduarte.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pauloduarte.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Transactional(readOnly=true)//readOnly para ficar mais rapida/diminuir o locking na gestão de transações da bas de dados
	Cliente findByEmail(String email);

}
