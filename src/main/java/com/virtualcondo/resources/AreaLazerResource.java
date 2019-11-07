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

import com.virtualcondo.models.AreaLazer;
import com.virtualcondo.services.AreaLazerService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/area-lazer")
public class AreaLazerResource {
	
	@Autowired
	private AreaLazerService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		AreaLazer obj = null;
		try {
			obj = service.buscar(id);
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findall(){
		List<AreaLazer> areaLazer = service.listar();
		return ResponseEntity.ok().body(areaLazer);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> salvar(@RequestBody AreaLazer areaLazer){
		areaLazer = service.salvar(areaLazer);
		return ResponseEntity.ok().body(areaLazer);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> editar(@RequestBody AreaLazer areaLazer){
		areaLazer = service.editar(areaLazer);
		return ResponseEntity.ok().body(areaLazer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		boolean resultado = service.deletar(id);
		if(resultado) return ResponseEntity.ok().body("{\"details\": \"Area de Lazer deletada com sucesso!\"}");
		else return ResponseEntity.ok().body("{\"details\": \"Erro ao deletar o id "+ id +"\"}");
	}

}
