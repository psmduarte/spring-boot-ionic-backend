package com.pauloduarte.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.aspectj.weaver.NewFieldTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pauloduarte.cursomc.domain.Cliente;
import com.pauloduarte.cursomc.domain.enums.TipoCliente;
import com.pauloduarte.cursomc.dto.ClienteNewDTO;
import com.pauloduarte.cursomc.repositories.ClienteRepository;
import com.pauloduarte.cursomc.resources.exception.FieldMessage;
import com.pauloduarte.cursomc.services.validation.utils.PT;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOASINGULAR.getCodigo()) && !PT.isValidNifS(objDto.getNif())) {
			list.add(new FieldMessage("nif", "Nif invalido PessoaSingular"));
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOACOLECTIVA.getCodigo()) && !PT.isValidNifC(objDto.getNif())) {
			list.add(new FieldMessage("nif", "Nif invalido Colectiva"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "O email já existe!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}