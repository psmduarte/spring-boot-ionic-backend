package com.pauloduarte.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pauloduarte.cursomc.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=3, max=120, message="O tamanho deve ser entre 3 e 120 caracteres.")
	private String nome;
	@NotEmpty(message="Email Obrigatório")
	@Email(message="Email inválido")
	private String email;
	@NotEmpty(message="Email Obrigatório")
	
	private String nif;
	private Integer tipo;
	
	@NotEmpty(message="Nome da rua Obrigatório")
	private String rua;
	@NotEmpty(message="Email Obrigatório")
	private String numero;
	private String complemento;
	private String bairro;
	@NotEmpty(message="Email Obrigatório")
	private String codigopostal;
	
	@NotEmpty(message="Email Obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
}
