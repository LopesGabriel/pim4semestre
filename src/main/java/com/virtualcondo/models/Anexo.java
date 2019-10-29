package com.virtualcondo.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Anexo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String caminho;
	private Double tamanho;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpload;
	private Morador fornecedor;
	private String ext;

	public Anexo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public Date getDtUpload() {
		return dtUpload;
	}

	public void setDtUpload(Date dtUpload) {
		this.dtUpload = dtUpload;
	}

	public Morador getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Morador fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
