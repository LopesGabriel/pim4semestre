package com.virtualcondo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcondo.models.Apartamento;
import com.virtualcondo.services.ApartamentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/apartamentos")
public class ApartamentoResource {

	@Autowired
	private ApartamentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Apartamento apt = null;
		try {
			apt = service.buscar(id);
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(apt);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Apartamento> lista = service.listar();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Apartamento ap){
		ap = service.salvar(ap);
		return ResponseEntity.ok().body(ap);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Apartamento ap){
		ap = service.salvar(ap);
		return ResponseEntity.ok().body(ap);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		boolean resultado = service.deletar(id);
		if(resultado) return ResponseEntity.ok().body(resultado);
		else return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resultado);
	}
}
