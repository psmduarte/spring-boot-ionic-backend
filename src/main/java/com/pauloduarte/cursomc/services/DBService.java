package com.pauloduarte.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Categoria;
import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.domain.Distrito;
import com.pauloduarte.cursomc.domain.ItemPedido;
import com.pauloduarte.cursomc.domain.Morada;
import com.pauloduarte.cursomc.domain.Pagamento;
import com.pauloduarte.cursomc.domain.PagamentoComCartao;
import com.pauloduarte.cursomc.domain.PagamentoComPrestacao;
import com.pauloduarte.cursomc.domain.Pedido;
import com.pauloduarte.cursomc.domain.Produto;
import com.pauloduarte.cursomc.domain.enums.EstadoPagamento;
import com.pauloduarte.cursomc.domain.enums.Perfil;
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

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	
	public void instantiateTestDatabase() throws ParseException {
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
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200);
		Produto p7 = new Produto(null, "TV Color 3D", 1200.00);
		Produto p8 = new Produto(null, "Motorroçadora", 500.00);
		Produto p9 = new Produto(null, "Candeeiro", 100.00);
		Produto p10 = new Produto(null, "Fio de candeeiro", 20.00);
		Produto p11 = new Produto(null , "Shampoo", 5.00);
		Produto p12 = new Produto(null , "Produto 12", 5.00);
		Produto p13 = new Produto(null , "Produto 12", 5.00);
		Produto p14 = new Produto(null , "Produto 12", 5.00);
		Produto p15 = new Produto(null , "Produto 12", 5.00);
		Produto p16 = new Produto(null , "Produto 12", 5.00);
		Produto p17 = new Produto(null , "Produto 12", 5.00);
		Produto p18 = new Produto(null , "Produto 12", 5.00);
		Produto p19 = new Produto(null , "Produto 12", 5.00);
		Produto p20 = new Produto(null , "Produto 12", 5.00);
		Produto p21 = new Produto(null , "Produto 12", 5.00);
		Produto p22 = new Produto(null , "Produto 12", 5.00);
		Produto p23 = new Produto(null , "Produto 12", 5.00);
		Produto p24 = new Produto(null , "Produto 12", 5.00);
		Produto p25 = new Produto(null , "Produto 12", 5.00);
		Produto p26 = new Produto(null , "Produto 12", 5.00);
		Produto p27 = new Produto(null , "Produto 12", 5.00);
		Produto p28 = new Produto(null , "Produto 12", 5.00);
		Produto p29 = new Produto(null , "Produto 12", 5.00);
		Produto p30 = new Produto(null , "Produto 12", 5.00);
		Produto p31 = new Produto(null , "Produto 12", 5.00);
		Produto p32 = new Produto(null , "Produto 12", 5.00);
		Produto p33 = new Produto(null , "Produto 12", 5.00);
		Produto p34 = new Produto(null , "Produto 12", 5.00);
		Produto p35 = new Produto(null , "Produto 12", 5.00);
		Produto p36 = new Produto(null , "Produto 12", 5.00);
		Produto p37 = new Produto(null , "Produto 12", 5.00);
		Produto p38 = new Produto(null , "Produto 12", 5.00);
		Produto p39 = new Produto(null , "Produto 12", 5.00);
		Produto p40 = new Produto(null , "Produto 12", 5.00);
		Produto p41 = new Produto(null , "Produto 12", 5.00);
		Produto p42 = new Produto(null , "Produto 12", 5.00);
		Produto p43 = new Produto(null , "Produto 12", 5.00);
		Produto p44 = new Produto(null , "Produto 12", 5.00);
		Produto p45 = new Produto(null , "Produto 12", 5.00);
		Produto p46 = new Produto(null , "Produto 12", 5.00);
		Produto p47 = new Produto(null , "Produto 12", 5.00);
		Produto p48 = new Produto(null , "Produto 12", 5.00);
		Produto p49 = new Produto(null , "Produto 12", 5.00);
		Produto p50 = new Produto(null , "Produto 12", 5.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p11, p12,p13, p14, p15 ,p16, p17, p18, p19, p20,
				p21, p22 ,p23,p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, 
				p38, p39, p40,p41, p42, p43,p44, p45, p46, p47, p48, p49, p50));
		
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5 ,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		p12.getCategorias().addAll(Arrays.asList(cat1));
		p13.getCategorias().addAll(Arrays.asList(cat1));
		p14.getCategorias().addAll(Arrays.asList(cat1));
		p15.getCategorias().addAll(Arrays.asList(cat1));
		p16.getCategorias().addAll(Arrays.asList(cat1));
		p17.getCategorias().addAll(Arrays.asList(cat1));
		p18.getCategorias().addAll(Arrays.asList(cat1));
		p19.getCategorias().addAll(Arrays.asList(cat1));
		p20.getCategorias().addAll(Arrays.asList(cat1));
		p21.getCategorias().addAll(Arrays.asList(cat1));
		p22.getCategorias().addAll(Arrays.asList(cat1));
		p23.getCategorias().addAll(Arrays.asList(cat1));
		p24.getCategorias().addAll(Arrays.asList(cat1));
		p25.getCategorias().addAll(Arrays.asList(cat1));
		p26.getCategorias().addAll(Arrays.asList(cat1));
		p27.getCategorias().addAll(Arrays.asList(cat1));
		p28.getCategorias().addAll(Arrays.asList(cat1));
		p29.getCategorias().addAll(Arrays.asList(cat1));
		p30.getCategorias().addAll(Arrays.asList(cat1));
		p31.getCategorias().addAll(Arrays.asList(cat1));
		p32.getCategorias().addAll(Arrays.asList(cat1));
		p33.getCategorias().addAll(Arrays.asList(cat1));
		p34.getCategorias().addAll(Arrays.asList(cat1));
		p35.getCategorias().addAll(Arrays.asList(cat1));
		p36.getCategorias().addAll(Arrays.asList(cat1));
		p37.getCategorias().addAll(Arrays.asList(cat1));
		p38.getCategorias().addAll(Arrays.asList(cat1));
		p39.getCategorias().addAll(Arrays.asList(cat1));
		p40.getCategorias().addAll(Arrays.asList(cat1));
		p41.getCategorias().addAll(Arrays.asList(cat1));
		p42.getCategorias().addAll(Arrays.asList(cat1));
		p43.getCategorias().addAll(Arrays.asList(cat1));
		p44.getCategorias().addAll(Arrays.asList(cat1));
		p45.getCategorias().addAll(Arrays.asList(cat1));
		p46.getCategorias().addAll(Arrays.asList(cat1));
		p47.getCategorias().addAll(Arrays.asList(cat1));
		p48.getCategorias().addAll(Arrays.asList(cat1));
		p49.getCategorias().addAll(Arrays.asList(cat1));
		p50.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
		produtoRepository.saveAll(Arrays.asList( p12,p13, p14, p15 ,p16, p17, p18, p19, p20,
				p21, p22 ,p23,p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, 
				p38, p39, p40,p41, p42, p43,p44, p45, p46, p47, p48, p49, p50));
		
		Distrito dist1 = new Distrito(null,"Portalegre");
		Distrito dist2 = new Distrito(null,"Lisboa");
		
		Cidade c1 = new Cidade(null, "Ponte de Sor", dist1);
		Cidade c2 = new Cidade(null, "Mafra", dist2);
		Cidade c3 = new Cidade(null, "Loures", dist2);
		
		dist1.getCidades().addAll(Arrays.asList(c1));
		dist2.getCidades().addAll(Arrays.asList(c2,c3));
		
		distritoRepository.saveAll(Arrays.asList(dist1,dist2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Pilar", "psmduarte@live.com", "219032882", TipoCliente.PESSOASINGULAR, pe.encode("1234"));
		cli1.getTelefones().addAll(Arrays.asList("111111111","222222222"));

		Cliente cli2 = new Cliente(null, "Daniela Chambel", "danielachambel@hotmail.com", "214888398", TipoCliente.PESSOASINGULAR, pe.encode("1234"));
		cli1.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("33333333","444444444"));

		
		Morada m1 = new Morada(null, "Rua das Flores", "300", "2º/Esq.", "Jardim", "7358-123", cli1, c1);		
		Morada m2 = new Morada(null,"Avenida Matos","105","sala 21","Centro","6058-132",cli1,c2);
		Morada m3 = new Morada(null,"Avenida da Carqueia","105",null,"Centro","74444-132",cli2,c2);
		
		cli1.getMoradas().addAll(Arrays.asList(m1,m2));
		cli2.getMoradas().addAll(Arrays.asList(m3));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		moradaRepository.saveAll(Arrays.asList(m1,m2, m3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2018 10:52"), cli1, m1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/03/2018 21:29"), cli1, m2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.FATURADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComPrestacao(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2018 00:00"), null);
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
