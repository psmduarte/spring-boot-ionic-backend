package com.pauloduarte.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date instante;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;

	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="morada_de_entrega_id")
	private Morada moradaEntrega;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> items = new HashSet<>();
	

	public Pedido() {
	}

	public Pedido(Integer id, Date instante, Cliente cliente, Morada moradaEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.moradaEntrega = moradaEntrega;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		for(ItemPedido ip : items) {      //Por cada item pedido ip na minha lista de items
			soma=soma+ip.getSubtotal();	  //vamos acumular a soma do valor desses items
		}
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Morada getMoradaEntrega() {
		return moradaEntrega;
	}

	public void setMoradaEntrega(Morada moradaEntrega) {
		this.moradaEntrega = moradaEntrega;
	}
	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido numero: ");
		builder.append(getId());
		builder.append(", instante: ");
		builder.append(getInstante());
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situação do Pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		builder.append("\nDetalhes:\n");
		for(ItemPedido ip: getItems()) {   //Para cada pedido ip na lista de itens do pedido
			builder.append(ip.toString());	//vou concatenar ip com toString;
		}
		builder.append("Valor total: ");
		builder.append(getValorTotal());
		return builder.toString();
	}

	
	
}
