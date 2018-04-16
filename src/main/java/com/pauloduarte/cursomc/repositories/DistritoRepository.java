package com.pauloduarte.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pauloduarte.cursomc.domain.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

}
