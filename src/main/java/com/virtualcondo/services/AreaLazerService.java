package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcondo.models.AreaLazer;
import com.virtualcondo.repository.AreaLazerRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AreaLazerService {
	
	@Autowired
	private AreaLazerRepository repo;
	
	public AreaLazer buscar(Long id) throws ObjectNotFoundException {
		Optional<AreaLazer> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + AreaLazer.class.getName()));
	}
	
	public List<AreaLazer> listar(){
		List<AreaLazer> lista = repo.findAll();
		return lista;
	}
	
	public AreaLazer salvar(AreaLazer a) {
		a = repo.save(a);
		return a;
	}
	
	public AreaLazer editar(AreaLazer a) {
		a = repo.save(a);
		return a;
	}
	
	public boolean deletar(Long id) {
		repo.deleteById(id);
		Optional<AreaLazer> v = repo.findById(id);
		if(!v.isPresent()) return true;
		else return false;
	}

}
