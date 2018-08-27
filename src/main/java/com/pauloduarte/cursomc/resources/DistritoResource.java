package com.pauloduarte.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pauloduarte.cursomc.domain.Cidade;
import com.pauloduarte.cursomc.domain.Distrito;
import com.pauloduarte.cursomc.dto.CidadeDTO;
import com.pauloduarte.cursomc.dto.DistritoDTO;
import com.pauloduarte.cursomc.services.CidadeService;
import com.pauloduarte.cursomc.services.DistritoService;

@RestController
@RequestMapping(value="/distritos")
public class DistritoResource {
	
	@Autowired	
	private DistritoService service;
	
	@Autowired
	private CidadeService CidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DistritoDTO>> findAll(){
		List<Distrito> list =service.findAll();
		List<DistritoDTO> listDto = list.stream().map(obj -> new DistritoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{distritoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer distritoId){
		List<Cidade> list = CidadeService.findByDistrito(distritoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
