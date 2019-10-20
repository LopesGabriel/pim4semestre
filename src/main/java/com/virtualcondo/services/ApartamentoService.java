package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcondo.models.Apartamento;
import com.virtualcondo.repository.ApartamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository repo;

	public Apartamento buscar(Integer id) throws ObjectNotFoundException {
		Optional<Apartamento> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Apartamento.class.getName()));
	}

	public List<Apartamento> listar(){
		List<Apartamento> lista = repo.findAll();
		return lista;
	}

	public Apartamento salvar(Apartamento a) {
		a = repo.save(a);
		return a;
	}

	public Apartamento editar(Apartamento a) {
		a = repo.save(a);
		return a;
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Apartamento> a = repo.findById(id);
		if(!a.isPresent()) return true;
		else return false;
	}
}
