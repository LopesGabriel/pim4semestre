package com.virtualcondo.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AreaLazer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String espaco;
	
	@Column(nullable = false)
	private String hora_de_abertura;
	
	@Column(nullable = false)
	private String hora_de_fechamento;
	private Float preco_aluguel;
	
	public AreaLazer() {
		super();
	}

	public AreaLazer(Long id, String espaco, String hora_de_abertura, String hora_de_fechamento, Float preco_aluguel) {
		super();
		this.id = id;
		this.espaco = espaco;
		this.hora_de_abertura = hora_de_abertura;
		this.hora_de_fechamento = hora_de_fechamento;
		this.preco_aluguel = preco_aluguel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspaco() {
		return espaco;
	}

	public void setEspaco(String espaco) {
		this.espaco = espaco;
	}

	public String getHora_entrada() {
		return hora_de_abertura;
	}

	public void setHora_entrada(String hora_de_abertura) {
		this.hora_de_abertura = hora_de_abertura;
	}

	public String getHora_saida() {
		return hora_de_fechamento;
	}

	public void setHora_saida(String hora_de_fechamento) {
		this.hora_de_fechamento = hora_de_fechamento;
	}

	public Float getPreco_total() {
		return preco_aluguel;
	}

	public void setPreco_total(Float preco_aluguel) {
		this.preco_aluguel = preco_aluguel;
	}
	
	

}
