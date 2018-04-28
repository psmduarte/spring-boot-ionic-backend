package com.pauloduarte.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.domain.Morada;
import com.pauloduarte.cursomc.domain.enums.TipoCliente;
import com.pauloduarte.cursomc.dto.ClienteDTO;
import com.pauloduarte.cursomc.dto.ClienteNewDTO;
import com.pauloduarte.cursomc.repositories.CidadeRepository;
import com.pauloduarte.cursomc.repositories.ClienteRepository;
import com.pauloduarte.cursomc.services.exceptions.DataIntegrityException;
import com.pauloduarte.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente>obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objecto não encontrado id:" + id + "Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente insert(Cliente obj){
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir porque existem entidades relacionadas");
		}
		
	}
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getNif(), TipoCliente.toEnum(objDto.getTipo()));
		Cidade cid = cidadeRepository.findOne(objDto.getCidadeId());
		Morada mor = new Morada(null, objDto.getRua(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCodigopostal(), cli, cid);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
