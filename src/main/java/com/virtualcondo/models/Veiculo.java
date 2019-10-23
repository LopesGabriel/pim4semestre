package com.virtualcondo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String marca;
	private String placa;
	private String vagaEstacionamento;
	@OneToOne(targetEntity = Morador.class)
	private Morador dono;

	public Veiculo() {}

	public Veiculo(Integer id, String marca, String placa, String vagaEstacionamento, Morador dono) {
		super();
		this.id = id;
		this.marca = marca;
		this.placa = placa;
		this.vagaEstacionamento = vagaEstacionamento;
		this.dono = dono;
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

	public String getVagaEstacionamento() {
		return vagaEstacionamento;
	}

	public void setVagaEstacionamento(String vagaEstacionamento) {
		this.vagaEstacionamento = vagaEstacionamento;
	}

	public Morador getDono() {
		return dono;
	}

	public void setDono(Morador dono) {
		this.dono = dono;
	}
	
}
