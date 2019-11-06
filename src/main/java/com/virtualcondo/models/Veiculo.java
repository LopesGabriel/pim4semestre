package com.virtualcondo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "veiculos_morador", joinColumns = {@JoinColumn(name="veiculo_id")}, inverseJoinColumns = {@JoinColumn(name="morador_id")})
	private List<Morador> moradores;
	
	public Veiculo() {}

	public Veiculo(Integer id, String marca, String placa, VagaEstacionamento vagaEstacionamento, List<Morador> moradores) {
		super();
		this.id = id;
		this.marca = marca;
		this.placa = placa;
		this.vagaEstacionamento = vagaEstacionamento;
		this.moradores = moradores;
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

	public List<Morador> getmorador() {
		return moradores;
	}

	public void setmorador(List<Morador> moradores) {
		this.moradores = moradores;
	}
	
}
