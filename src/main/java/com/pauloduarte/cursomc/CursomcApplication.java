package com.pauloduarte.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pauloduarte.cursomc.domain.Categoria;
import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.domain.Distrito;
import com.pauloduarte.cursomc.domain.ItemPedido;
import com.pauloduarte.cursomc.domain.Morada;
import com.pauloduarte.cursomc.domain.Pagamento;
import com.pauloduarte.cursomc.domain.PagamentoComCartao;
import com.pauloduarte.cursomc.domain.PagamentoComPaypal;
import com.pauloduarte.cursomc.domain.Pedido;
import com.pauloduarte.cursomc.domain.Produto;
import com.pauloduarte.cursomc.domain.enums.EstadoPagamento;
import com.pauloduarte.cursomc.domain.enums.TipoCliente;
import com.pauloduarte.cursomc.repositories.CategoriaRepository;
import com.pauloduarte.cursomc.repositories.CidadeRepository;
import com.pauloduarte.cursomc.repositories.ClienteRepository;
import com.pauloduarte.cursomc.repositories.DistritoRepository;
import com.pauloduarte.cursomc.repositories.ItemPedidoRepository;
import com.pauloduarte.cursomc.repositories.MoradaRepository;
import com.pauloduarte.cursomc.repositories.PagamentoRepository;
import com.pauloduarte.cursomc.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private MoradaRepository moradaRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired 
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Mecânica");
		Categoria cat4 = new Categoria(null, "Laboratório");
		Categoria cat5 = new Categoria(null, "Matéria Prima");
		Categoria cat6 = new Categoria(null, "Ambiente");
		Categoria cat7 = new Categoria(null, "Eletricidade");
		
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@live.com", 123456789, TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("111111111","222222222"));
		
		Morada m1 = new Morada(null, "Rua das Flores", "300", "2º/Esq.", "Jardim", "7358-123", cli1, c1);		
		Morada m2 = new Morada(null,"Avenida Matos","105","sala 21","Centro","6058-132",cli1,c2);
		
		cli1.getMoradas().addAll(Arrays.asList(m1,m2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		moradaRepository.saveAll(Arrays.asList(m1,m2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2018 10:52"), cli1, m1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/03/2018 21:29"), cli1, m2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.FATURADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComPaypal(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2018 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1 ,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1,ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
