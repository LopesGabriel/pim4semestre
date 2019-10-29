package com.virtualcondo.resources;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.virtualcondo.models.Morador;
import com.virtualcondo.services.FotoService;
import com.virtualcondo.services.MoradorService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {

	@Autowired
	private MoradorService service;

	@Autowired
	private FotoService fotoService;

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

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Morador> moradores = service.listar();
		return ResponseEntity.ok().body(moradores);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> salvar(@RequestBody Morador morador){
		morador = service.salvar(morador);
		return ResponseEntity.ok().body(morador);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> editar(@RequestBody Morador morador){
		morador = service.editar(morador);
		return ResponseEntity.ok().body(morador);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		boolean resultado = service.deletar(id);
		if(resultado) return ResponseEntity.ok().body("{\"details\": \"Deletado com sucesso!\"}");
		else return ResponseEntity.ok().body("{\"details\": \"Erro ao deletar o id "+ id +"\"}");
	}

	@RequestMapping(value = "/foto/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFoto(@RequestParam MultipartFile foto, @PathVariable Integer id){

		Morador m;

		try{

			m = service.buscar(id);
			String[] nome = m.getNome().split(" ");

			File path = fotoService.salvarFoto(foto, nome[0]);
			m.setImg(path.getName());
			m = service.editar(m);

		}catch(ObjectNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(m);
	}
}
