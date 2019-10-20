package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcondo.models.Morador;
import com.virtualcondo.repository.MoradorRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository repo;

	public Morador buscar(Integer id) throws ObjectNotFoundException{
		Optional<Morador> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", tipo: " + Morador.class.getName()));
	}

	public List<Morador> listar(){
		List<Morador> lista = repo.findAll();
		return lista;
	}

	public Morador salvar(Morador m) {
		m = repo.save(m);
		return m;
	}

	public Morador editar(Morador m) {
		m = repo.save(m);
		return m;
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Morador> m = repo.findById(id);
		if(!m.isPresent()) return true;
		else return false;
	}

}
