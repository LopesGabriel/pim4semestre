package com.virtualcondo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcondo.models.Visitante;
import com.virtualcondo.services.VisitanteService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/visitantes")
public class VisitanteResource {

	@Autowired
	private VisitanteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Visitante obj = null;
		try {
			obj = service.buscar(id);
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> findAll(){
		List<Visitante> visitantes = service.listar();
		return ResponseEntity.ok().body(visitantes);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> salvar(@RequestBody Visitante v){
		return ResponseEntity.ok().body(service.salvar(v));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> editar(@RequestBody Visitante v){
		return ResponseEntity.ok().body(service.editar(v));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = "application/json")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		boolean resultado = service.deletar(id);
		if(resultado) return ResponseEntity.ok().body("{\"details\": \"Deletado com sucesso!\"}");
		else return ResponseEntity.ok().body("{\"details\": \"Erro ao deletar o id "+ id +"\"}");
	}

}
