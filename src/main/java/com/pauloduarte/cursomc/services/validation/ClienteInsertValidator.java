package com.pauloduarte.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pauloduarte.cursomc.domain.enums.TipoCliente;
import com.pauloduarte.cursomc.dto.ClienteNewDTO;
import com.pauloduarte.cursomc.resources.exception.FieldMessage;
import com.pauloduarte.cursomc.services.validation.utils.PT;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
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
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}