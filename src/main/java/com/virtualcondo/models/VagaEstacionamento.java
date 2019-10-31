package com.virtualcondo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VagaEstacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String vaga;
	@OneToOne(targetEntity = Veiculo.class)
	@JoinColumn(name = "veiculo", referencedColumnName = "id")
	private Veiculo veiculo;
	private boolean emUso;
	@OneToOne(targetEntity = Morador.class)
	@JoinColumn(name = "dono", referencedColumnName = "id")
	private Morador morador;

	public VagaEstacionamento() {}

	public VagaEstacionamento(Integer id, String vaga, boolean emUso, Morador morador) {
		super();
		this.id = id;
		this.vaga = vaga;
		this.emUso = emUso;
		this.morador = morador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public boolean isEmUso() {
		return emUso;
	}

	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}

	public Morador getUsuario() {
		return morador;
	}

	public void setUsuario(Morador morador) {
		this.morador = morador;
	}

	

}
