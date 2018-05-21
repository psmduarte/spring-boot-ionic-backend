package com.pauloduarte.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pauloduarte.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("PagamentoComPrestacao")
public class PagamentoComPrestacao extends Pagamento {
	private static final long serialVersionUID=1L;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataPagamento;
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataVencimento;
	
	public PagamentoComPrestacao() {
	}

	public PagamentoComPrestacao(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento=dataPagamento;
		this.dataVencimento=dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVendicimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	
}
