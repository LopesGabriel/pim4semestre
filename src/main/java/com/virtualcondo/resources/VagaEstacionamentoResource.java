package com.virtualcondo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcondo.models.VagaEstacionamento;
import com.virtualcondo.services.VagaEstacionamentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/vagas")
public class VagaEstacionamentoResource {

	@Autowired
	private VagaEstacionamentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		VagaEstacionamento obj = null;
		try {
			obj = service.buscar(id);
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<VagaEstacionamento> vagas = service.listarTodos();
		return ResponseEntity.ok().body(vagas);
	}

	@RequestMapping(value = "/disponiveis", method = RequestMethod.GET)
	public ResponseEntity<?> findAllAvailable(){
		List<VagaEstacionamento> vagas = service.listarDisponivel();
		return ResponseEntity.ok().body(vagas);
	}

}
