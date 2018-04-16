package com.pauloduarte.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pauloduarte.cursomc.domain.Categoria;
import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.domain.Distrito;
import com.pauloduarte.cursomc.domain.Produto;
import com.pauloduarte.cursomc.repositories.CategoriaRepository;
import com.pauloduarte.cursomc.repositories.CidadeRepository;
import com.pauloduarte.cursomc.repositories.DistritoRepository;
import com.pauloduarte.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private DistritoRepository distritoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Distrito dist1 = new Distrito(null,"Portalegre");
		Distrito dist2 = new Distrito(null,"Lisboa");
		
		Cidade c1 = new Cidade(null, "Ponte de Sor", dist1);
		Cidade c2 = new Cidade(null, "Mafra", dist2);
		Cidade c3 = new Cidade(null, "Loures", dist2);
		
		dist1.getCidades().addAll(Arrays.asList(c1));
		dist2.getCidades().addAll(Arrays.asList(c2,c3));
		
		distritoRepository.saveAll(Arrays.asList(dist1,dist2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		
		
	}
}
