package com.virtualcondo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String marca;
	private String placa;
	@OneToOne(targetEntity = VagaEstacionamento.class)
	@JoinColumn(name = "vaga", referencedColumnName = "id")
	private VagaEstacionamento vagaEstacionamento;
	@OneToOne(targetEntity = Morador.class)
	@JoinColumn(name = "morador", referencedColumnName = "id")
	private Morador morador;

	public Veiculo() {}

	public Veiculo(Integer id, String marca, String placa, VagaEstacionamento vagaEstacionamento, Morador morador) {
		super();
		this.id = id;
		this.marca = marca;
		this.placa = placa;
		this.vagaEstacionamento = vagaEstacionamento;
		this.morador = morador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public VagaEstacionamento getVagaEstacionamento() {
		return vagaEstacionamento;
	}

	public void setVagaEstacionamento(VagaEstacionamento vagaEstacionamento) {
		this.vagaEstacionamento = vagaEstacionamento;
	}

	public Morador getmorador() {
		return morador;
	}

	public void setmorador(Morador morador) {
		this.morador = morador;
	}
	
}
