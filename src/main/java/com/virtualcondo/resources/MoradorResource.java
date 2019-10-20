package com.virtualcondo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcondo.models.Morador;
import com.virtualcondo.services.MoradorService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {

	@Autowired
	private MoradorService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Morador obj = null;
		try {
			obj = service.buscar(id);
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(obj);
	}
}
