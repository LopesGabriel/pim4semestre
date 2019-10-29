package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualcondo.models.Documento;
import com.virtualcondo.repository.DocumentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

public class DocumentoService {

	@Autowired
	private DocumentoRepository repo;

	public Documento buscar(Integer id) throws ObjectNotFoundException {
		Optional<Documento> doc = repo.findById(id);
		return doc.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Documento.class.getName()));
	}

	public List<Documento> listar(){
		List<Documento> lista = repo.findAll();
		return lista;
	}

	public Documento salvar(Documento doc) {
		doc = repo.save(doc);
		return doc;
	}

	public Documento editar(Documento doc) {
		doc = repo.save(doc);
		return doc;
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Documento> doc = repo.findById(id);
		if(!doc.isPresent()) return true;
		else return false;
	}

}
