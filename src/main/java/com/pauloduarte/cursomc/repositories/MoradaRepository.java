package com.pauloduarte.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pauloduarte.cursomc.domain.Morada;

@Repository
public interface MoradaRepository extends JpaRepository<Morada, Integer> {

}
