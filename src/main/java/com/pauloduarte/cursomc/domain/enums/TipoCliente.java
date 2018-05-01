package com.pauloduarte.cursomc.domain.enums;


public enum TipoCliente {
	PESSOASINGULAR (1,"Pessoa Singular"),     
	PESSOACOLECTIVA (2,"Pessoa Colectiva");
	
	
	private int codigo;
	private String descricao;
	
	private TipoCliente (int codigo, String descricao) {
		this.codigo=codigo;
		this.descricao=descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {    //Ciclo For que percorre todos os valores de tipo de cliente
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Invalido: " + codigo);
	}
}
	
