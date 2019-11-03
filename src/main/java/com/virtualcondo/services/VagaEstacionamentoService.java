package com.virtualcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualcondo.models.VagaEstacionamento;
import com.virtualcondo.repository.VagaEstacionamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VagaEstacionamentoService {

	@Autowired
	private VagaEstacionamentoRepository repo;

	public VagaEstacionamento buscar(Integer id) throws ObjectNotFoundException {
		Optional<VagaEstacionamento> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + VagaEstacionamento.class.getName()) );
	}

	public List<VagaEstacionamento> listarDisponivel(){
		return new JDBCVagaEstacionamentoService().listarDisponiveis();
	}

	public List<VagaEstacionamento> listarTodos(){
		List<VagaEstacionamento> lista = repo.findAll();
		return lista;
	}

	public VagaEstacionamento salvar(VagaEstacionamento ve) {
		ve = repo.save(ve);
		return ve;
	}

	public VagaEstacionamento editar(VagaEstacionamento ve) {
		ve = repo.save(ve);
		return ve;
	}

	public VagaEstacionamento resetVaga(VagaEstacionamento ve) {
		VagaEstacionamento vaga = new VagaEstacionamento();
		vaga.setEmUso(false);
		vaga.setId(ve.getId());
		vaga.setVaga(ve.getVaga());
		vaga.setUsuario(null);

		repo.deleteById(ve.getId());
		vaga = repo.save(vaga);
		return vaga;
	}

}
