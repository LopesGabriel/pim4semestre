package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualcondo.models.Veiculo;
import com.virtualcondo.repository.VeiculoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

public class VeiculoService {

	@Autowired
	private VeiculoRepository repo;

	public Veiculo buscar(Integer id) throws ObjectNotFoundException {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Veiculo.class.getName()));
	}

	public List<Veiculo> listar(){
		List<Veiculo> lista = repo.findAll();
		return lista;
	}

	public Veiculo salvar(Veiculo v) {
		v = repo.save(v);
		return v;
	}

	public Veiculo editar(Veiculo v) {
		v = repo.save(v);
		return v;
	}

	public boolean deletar(Integer id) {
		repo.deleteById(id);
		Optional<Veiculo> v = repo.findById(id);
		if(!v.isPresent()) return true;
		else return false;
	}
}
