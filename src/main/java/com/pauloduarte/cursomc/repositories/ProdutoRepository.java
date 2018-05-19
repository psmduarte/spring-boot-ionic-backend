package com.pauloduarte.cursomc.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloduarte.cursomc.domain.Categoria;
import com.pauloduarte.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	//Existe esta maneira de fazer a pesquisa por nome relacionando com a categoria(ao escolher o metodo
	//tem de se ajustar tambem no ProdutoService, que pode ser return repo.findDistinctByNomeContainingAndCategoriasIn neste caso.

	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
	
	//E existe também esta maneira:(Aqui no ProdutoService fica return.search
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	//Page<Produto> search(@Param("nome")String nome,@Param("categorias") List <Categoria> categorias, Pageable pageRequest);

	
}
