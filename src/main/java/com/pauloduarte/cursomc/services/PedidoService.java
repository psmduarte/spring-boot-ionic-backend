package com.pauloduarte.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pauloduarte.cursomc.domain.ItemPedido;
import com.pauloduarte.cursomc.domain.PagamentoComPrestacao;
import com.pauloduarte.cursomc.domain.Pedido;
import com.pauloduarte.cursomc.domain.enums.EstadoPagamento;
import com.pauloduarte.cursomc.repositories.ItemPedidoRepository;
import com.pauloduarte.cursomc.repositories.PagamentoRepository;
import com.pauloduarte.cursomc.repositories.PedidoRepository;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PrestacaoService prestacaoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired 
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository intemPedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido>obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objecto não encontrado Id:" + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		//obj.setCliente(ClienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComPrestacao) {
			PagamentoComPrestacao pagto = (PagamentoComPrestacao) obj.getPagamento();	
			prestacaoService.preencherPagamentoComPrestacao(pagto, obj.getInstante());
			}
		obj = repo.save(obj);    //Guarda o pedido
		pagamentoRepository.save(obj.getPagamento());  //Guarda Pagamento
		for(ItemPedido ip: obj.getItems()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());  //Procura no banco de dados o preco correspondente ao produto pelo id deste
			ip.setPedido(obj);
		}
		intemPedidoRepository.saveAll(obj.getItems());
		System.out.println(obj);
		return obj;
		
	}

}
