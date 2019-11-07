package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcondo.models.Visitante;
import com.virtualcondo.repository.VisitanteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VisitanteService {

	@Autowired
	private VisitanteRepository repo;

	public Visitante buscar (Integer id) throws ObjectNotFoundException{

		Optional<Visitante> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Visitante.class.getName()
		));

	}

	public List<Visitante> listar(){
		return repo.findAll();
	}

	public Visitante salvar(Visitante v) {
		return repo.save(v);
	}

	public Visitante editar(Visitante v) {
		return repo.save(v);
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Visitante> v = repo.findById(id);
		if(!v.isPresent()) return true;
		else return false;
	}

}
