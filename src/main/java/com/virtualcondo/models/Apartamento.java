package com.virtualcondo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Apartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String bloco;
	private String unidade;
	private String interfone;

	@OneToOne
	private Morador proprietario;

	@OneToMany(targetEntity = Morador.class)
	private List<Morador> moradores;
	@OneToMany(targetEntity = Veiculo.class)
	private List<Veiculo> veiculos;

	public Apartamento() {}

	public Apartamento(Integer id, String bloco, String unidade, String interfone, Morador proprietario) {
		super();
		this.id = id;
		this.bloco = bloco;
		this.unidade = unidade;
		this.interfone = interfone;
		this.proprietario = proprietario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getInterfone() {
		return interfone;
	}

	public void setInterfone(String interfone) {
		this.interfone = interfone;
	}

	public Morador getProprietario() {
		return proprietario;
	}

	public void setProprietario(Morador proprietario) {
		this.proprietario = proprietario;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
