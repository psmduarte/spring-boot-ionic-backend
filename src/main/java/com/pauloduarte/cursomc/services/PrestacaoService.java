package com.pauloduarte.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.PagamentoComPrestacao;

@Service
public class PrestacaoService {
	
	public void preencherPagamentoComPrestacao(PagamentoComPrestacao pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7); //Tem 7 dias a partir da compra para pagar tudo por exemplo
		pagto.setDataVendicimento(cal.getTime());
	}
}
