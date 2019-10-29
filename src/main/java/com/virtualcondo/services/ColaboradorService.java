package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualcondo.models.Colaborador;
import com.virtualcondo.repository.ColaboradorRepository;

import javassist.tools.rmi.ObjectNotFoundException;

public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repo;

	public Colaborador buscar(Integer id) throws ObjectNotFoundException{
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Colaborador não foi encontrado! Id: " + id + ", tipo: " + Colaborador.class.getName()) );
	}

	public List<Colaborador> listar(){
		List<Colaborador> lista = repo.findAll();
		return lista;
	}

	public Colaborador salvar(Colaborador c) {
		c = repo.save(c);
		return c;
	}

	public Colaborador editar(Colaborador c) {
		c = repo.save(c);
		return c;
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Colaborador> c = repo.findById(id);
		if(!c.isPresent()) return true;
		else return false;
	}

}
